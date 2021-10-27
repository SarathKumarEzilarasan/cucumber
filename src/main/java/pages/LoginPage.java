package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.actions.ClickUtil;
import utils.actions.SetUtil;


public class LoginPage extends BasePage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement submit;


    public LoginPage search(String text) {
        SetUtil.setElement(searchBox,text);
        ClickUtil.click(submit);
        return this;
    }

}
