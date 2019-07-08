package testprovisions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static DriverProvider driverProvider = new DriverProvider();
    public static WebDriver driver;
    private ChromeOptions chromeOptions;
    private static Logger logger;

    public static DriverProvider getInstance() {
        return driverProvider;
    }

    private DriverProvider() {
        initialiseDriver();
    }

    private void initialiseDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/test/resources/chromedriver.exe");
        logger = LoggerFactory.getLogger("DriverProvider");
        setChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        logger.info("initialised driver");
        maximiseBrowserWindow();
        setTimeoutAndWait();
        clearBrowserCookies();
    }

    private void setChromeOptions(){
        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--incognito");
        logger.info("setting up incognito and headless mode");
    }

    private void maximiseBrowserWindow(){
        driver.manage().window().maximize();
        logger.info("maximising browser");
    }

    static void clearBrowserCookies(){
        driver.manage().deleteAllCookies();
        logger.info("deleting cookies");
    }

    private void setTimeoutAndWait(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        logger.info("setting timeouts");
    }
}
