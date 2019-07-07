package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PeopleAndOrganisationPage;
import testprovisions.DriverProvider;

public class CreatingCasesTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    PeopleAndOrganisationPage peopleAndOrganisation;

    @BeforeSuite
    public void launchAppBeforeTest(){
        DriverProvider.getInstance();
        loginPage = LoginPage.getLoginPage();
        dashboardPage = DashboardPage.getDashboardPage();
        peopleAndOrganisation = PeopleAndOrganisationPage.getPeopleAndOrganisation();
        loginPage.openApp();
    }

    @Test
    public void addingCase(){
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
        dashboardPage.clickPeopleAndOrganisation();
        peopleAndOrganisation.addPerson("Mr", "Pradeep","Srinivasan","Engineer", "FictionalCo","Member","+19999999999");
    }
}
