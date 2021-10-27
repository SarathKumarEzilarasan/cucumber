package utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.driver.DriverManager.getDriver;

public class WaitUtil {
    static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    public static void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForUrl(String str) {
        wait.until(ExpectedConditions.urlContains(str));
    }

    public static void waitTillVisible(By by) throws InterruptedException {
        long totalWait = 0;
        while (!getDriver().findElement(by).isDisplayed()) {
            Thread.sleep(500);
            totalWait += 500;
            if (totalWait >= 1000) {
                break;
            }
        }
    }
}
