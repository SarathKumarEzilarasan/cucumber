package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static utils.ReadQaProps.getConfig;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver init() {
        String _driver = getConfig("driver");
        if (_driver.equals(Drivers.chrome.name())) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            driver = new ChromeDriver(option);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (_driver.equals(Drivers.firefox.name())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}

enum Drivers {
    chrome,
    firefox
}
