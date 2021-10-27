package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static utils.driver.DriverManager.getDriver;
import static utils.driver.DriverManager.quitDriver;

public class Hooks {
    private final Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void setUp() {
        getDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        endOfTest(scenario);
        quitDriver();
    }

    public void endOfTest(Scenario scenario) {
        if (scenario.getStatus() != null && scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                FileUtils.deleteDirectory(new File(reportDirectory));
                File destFile = new File(reportDirectory + "/failure_screenshots/" + screenshotName + "_" + formater.format(calendar.getTime()) + ".png");
                FileUtils.writeByteArrayToFile(destFile, scrFile);
                scenario.attach(scrFile, "image/png", "My screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("");
        log.info("==========================================================================");
        log.info("====================Test Scnario  " + scenario.getName() + "  " + scenario.getStatus().toString() + "===============================");
        log.info("==========================================================================");
        log.info("");
    }
}
