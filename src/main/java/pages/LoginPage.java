package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testprovisions.DriverProvider;
import utilities.TestPropertyProvider;

public class LoginPage {

    private static LoginPage loginPage = new LoginPage();
    private TestPropertyProvider testPropertyProvider = TestPropertyProvider.getPropertyProvider();
    private static final Logger logger = LoggerFactory.getLogger("LoginPage");

    @FindBy(xpath = ".//input[contains(@id,'login:username')]")
    private WebElement usernameField;

    @FindBy(xpath = ".//input[contains(@id,'login:password')]")
    private WebElement passwordField;

    @FindBy(xpath = ".//input[@value='Log In']")
    private WebElement logInButton;

    private LoginPage(){
        PageFactory.initElements(DriverProvider.driver, this);
    }

    public static LoginPage getLoginPage(){
        return loginPage;
    }

    public void openApp(){
        DriverProvider.driver.get(testPropertyProvider.getProperty("AUTLink"));
        logger.info("opening AUT");
    }

    public void enterUserName(){
        usernameField.sendKeys(testPropertyProvider.getProperty("Username"));
        logger.info("entering username");
    }

    public void enterPassword(){
        passwordField.sendKeys(testPropertyProvider.getProperty("Password"));
        logger.info("entering password");
    }

    public void clickLoginButton(){
        logInButton.click();
        logger.info("logging in");
    }
}
