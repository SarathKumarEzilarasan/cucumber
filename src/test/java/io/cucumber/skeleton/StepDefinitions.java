package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static utils.ReadQaProps.getConfig;
import static utils.driver.DriverManager.getDriver;

public class StepDefinitions {
    Logger log = Logger.getLogger(StepDefinitions.class);
    WebDriver driver = getDriver();

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        driver.get(getConfig("url"));

        LoginPage page = new LoginPage(driver);
        page.search("udemy");
        log.info("Search Complete");
    }

    @When("I wait {int} hour")
    public void iWaitHour(int arg0) {
        Assert.assertEquals(1, 0);
    }

    @Then("my belly should growl")
    public void myBellyShouldGrowl() {
    }
}
