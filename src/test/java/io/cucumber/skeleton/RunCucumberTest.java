package io.cucumber.skeleton;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ReadQaProps;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"})
public class RunCucumberTest {
    @BeforeClass
    public static void setConfig(){
        ReadQaProps.config();
    }
}
