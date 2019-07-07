package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import testprovisions.DriverProvider;

public class CasesPage {
    private static CasesPage casesPage = new CasesPage();
    private static final Logger logger = LoggerFactory.getLogger("CasesPage");
    private final String expectedCaseStatus = "Open";

    @FindBy(xpath = ".//a[@href='/case/add' and text()='Add Case']")
    private WebElement addCaseLink;

    @FindBy(xpath = ".//input[@role='searchbox' and contains(@placeholder,'Find a person')]")
    private WebElement casePerson;

    @FindBy(xpath = ".//div[@class='search-select-results']/div[position()=1]")
    private WebElement autoSuggestPerson;

    @FindBy(xpath = ".//input[@class='form-input-text']")
    private WebElement caseName;

    @FindBy(xpath = ".//textarea[@class='form-input-text']")
    private WebElement caseDescription;

    @FindBy(xpath = ".//input[@role='searchbox' and contains(@placeholder,'Type to search tags')]")
    private WebElement caseTags;

    @FindBy(xpath = ".//button[@type='submit' and text()='Save']")
    private WebElement saveCaseButton;

    @FindBy(xpath = ".//div[@class='entity-details-title']")
    private WebElement createdCaseName;

    @FindBy(xpath = ".//div[@class='entity-details-subtitle']//a")
    private WebElement createdCasePerson;

    @FindBy(xpath = ".//div[contains(text(),'Case status is')]/span")
    private WebElement createdCaseStatus;

    public static CasesPage getCasesPage() {
        return casesPage;
    }

    private CasesPage() {
        PageFactory.initElements(DriverProvider.driver, this);
    }


    public void startAddingCase(String casePerson, String caseName, String caseDescription, String caseTag) {
        addCaseLink.click();
        this.casePerson.sendKeys(casePerson);
        autoSuggestPerson.click();
        this.caseName.sendKeys(caseName);
        this.caseDescription.sendKeys(caseDescription);
        this.caseTags.sendKeys(caseTag);
        saveCaseButton.click();
        assertCaseCreation(caseName, casePerson, expectedCaseStatus);
    }

    private void assertCaseCreation(String expectedCaseName, String expectedCasePerson, String expectedCaseStatus) {
        Assert.assertEquals(createdCaseName.getText(), expectedCaseName, "Case Name does not match");
        Assert.assertEquals(createdCasePerson.getText(), expectedCasePerson, "Case person does not match");
        Assert.assertEquals(createdCaseStatus.getText(), expectedCaseStatus, "Case status is not open");
    }
}