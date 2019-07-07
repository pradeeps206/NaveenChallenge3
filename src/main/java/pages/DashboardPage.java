package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testprovisions.DriverProvider;

public class DashboardPage {

    private static DashboardPage dashboardPage = new DashboardPage();
    private static final Logger logger = LoggerFactory.getLogger("DashboardPage");

    @FindBy(xpath = ".//a[@aria-label='People & Organisations']")
    private WebElement peopleAndOrganisationLink;

    @FindBy(xpath=".//a[@aria-label='Cases']")
    private WebElement casesLink;

    private DashboardPage() {
        PageFactory.initElements(DriverProvider.driver, this);
    }

    public static DashboardPage getDashboardPage() {
        return dashboardPage;
    }

    public void clickPeopleAndOrganisation() {
        peopleAndOrganisationLink.click();
        logger.info("opening ppl and org");
    }

    public void clickCases(){
        casesLink.click();
        logger.info("opening cases");
    }
}
