package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testprovisions.DriverProvider;

public class PeopleAndOrganisationPage {

    private static final Logger logger = LoggerFactory.getLogger("PeopleAndOrganisationPage");
    private static PeopleAndOrganisationPage peopleAndOrganisation = new PeopleAndOrganisationPage();

    @FindBy(xpath = ".//a[text()='Add Person']")
    private WebElement newPersonLink;

    @FindBy(xpath = ".//input[contains(@id,'fn')]")
    private WebElement firstName;

    @FindBy(xpath = ".//input[contains(@id,'ln')]")
    private WebElement lastName;

    @FindBy(xpath = ".//select[@name='party:j_id108:j_id116']")
    private Select salutations;

    @FindBy(xpath = ".//input[contains(@id,'jobTitle')]")
    private WebElement jobTitle;

    @FindBy(xpath = ".//input[contains(@id,'org')]")
    private WebElement organisation;

    @FindBy(xpath=".//input[contains(@id,'tagCombo')]")
    private WebElement tags;

    @FindBy(xpath=".//input[contains(@class,'addTagButton')]")
    private WebElement addTagButton;

    @FindBy(xpath = ".//input[contains(@id,'number')]")
    private WebElement contactNumber;

    @FindBy(xpath=".//input[contains(@id,'save')]")
    private WebElement saveButton;

    public static PeopleAndOrganisationPage getPeopleAndOrganisation() {
        return peopleAndOrganisation;
    }

    private PeopleAndOrganisationPage() {
        PageFactory.initElements(DriverProvider.driver, this);
    }

    public void addPerson(String selectedOption, String firstName, String lastName, String jobTitle,String organisation, String tagName, String contactNumber) {
        newPersonLink.click();
        this.salutations.selectByVisibleText(selectedOption);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.jobTitle.sendKeys(jobTitle);
        this.organisation.sendKeys(organisation);
        tags.sendKeys(tagName);
        addTagButton.click();
        this.contactNumber.sendKeys(contactNumber);
        saveButton.click();
    }
}