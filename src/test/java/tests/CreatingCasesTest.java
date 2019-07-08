package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.CasesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PeopleAndOrganisationPage;
import testprovisions.DriverProvider;

public class CreatingCasesTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PeopleAndOrganisationPage peopleAndOrganisation;
    private CasesPage casesPage;

    @BeforeSuite
    public void launchAppBeforeTest() {
        DriverProvider.getInstance();
        loginPage = LoginPage.getLoginPage();
        dashboardPage = DashboardPage.getDashboardPage();
        peopleAndOrganisation = PeopleAndOrganisationPage.getPeopleAndOrganisationPage();
        casesPage = CasesPage.getCasesPage();
        loginPage.openApp();
    }

    @Test
    public void addingCase() {
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        dashboardPage.clickPeopleAndOrganisation();
        peopleAndOrganisation.addPerson("Mr", "Pradeep", "Srinivasan", "Engineer", "FictionalCo", "Member", "+19999999999");
        dashboardPage.clickCases();
        casesPage.startAddingCase("Pradeep Srinivasan", "CaseCreationForTest", "CaseDescription", "CaseTag");
    }
}
