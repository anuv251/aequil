package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BaseHomePage;
import pageObjects.LoginPage;
import utilities.SeleniumWrapper;

public class AssignmentTest extends BaseTest {

SeleniumWrapper sw = new SeleniumWrapper();

	@Test
	public void loginTest() {
		test = extent.startTest("LoginTest");
		LoginPage loginPage = new LoginPage(driver, test);
		BaseHomePage homePage = loginPage.login(sw.get_Data("standard_user"), sw.get_Data("password"));
		assertTrue(homePage.verifyPageTitle(), test);
		if (homePage.verifyPageTitle())
		{
			homePage.verifyLogout();
			test.log(LogStatus.PASS, "LoginTest passed");
		}
		else
		{
			homePage.verifyLogout();
			test.log(LogStatus.FAIL, "LoginTest Failed");
		}
		extent.endTest(test);
	}
		

	@Test
	public void logoutTest() {
		test = extent.startTest("logoutTest");
		LoginPage loginPage = new LoginPage(driver, test);
		BaseHomePage homePage = loginPage.login(sw.get_Data("standard_user"), sw.get_Data("password"));
		assertTrue(homePage.verifyLogout().verifyPageTitle(), test);
		if(homePage.verifyLogout().verifyPageTitle())
		{
			test.log(LogStatus.PASS, "LogoutTest Pass");
		}
		else
		{
			test.log(LogStatus.FAIL, "LogoutTest Failed");
		}
		
		extent.endTest(test);
	}

	@Test
	public void lockedUserTest() {
		test = extent.startTest("lockedTest");
		LoginPage loginPage = new LoginPage(driver, test);
		boolean result = loginPage.verifyLockedUser(sw.get_Data("locked_user"), sw.get_Data("password"));
		assertTrue(result, test);
		if(result)
		{
			test.log(LogStatus.PASS, "lockedUserTest Pass");
		}
		else
		{
			test.log(LogStatus.FAIL, "lockedUserTest Failed");
		}
		extent.endTest(test);
	}

	@Test
	public void userCaseSensitive() {
		test = extent.startTest("userCaseSensitive");
		LoginPage loginPage = new LoginPage(driver, test);
		boolean result = loginPage.verifyInvalidUser(sw.get_Data("case_sensitive"), sw.get_Data("password"));
		assertTrue(result, test);
		if(result)
		{
			test.log(LogStatus.PASS, "userCaseSensitive Pass");
		}
		else
		{
			test.log(LogStatus.FAIL, "userCaseSensitive Failed");
		}
		extent.endTest(test);
	}	
	
	
	
	@Test
	public void validateProblemUserTest() {
		test = extent.startTest("validateProblemUserTest");
		LoginPage loginPage = new LoginPage(driver, test);
		BaseHomePage homePage = loginPage.login(sw.get_Data("problem_user"), sw.get_Data("password"));
		boolean result = homePage.validateLoginProb();
		System.out.println(result);
		if (result)
		{
			test.log(LogStatus.PASS, "validateProblemUserTest pass");
		}
		else
		{
			test.log(LogStatus.FAIL, "validateProblemUserTest FAILED");
		}
		assertTrue(homePage.validateLoginProb(), test);	
		extent.endTest(test);
	}
	
	@Test
	public void validateCartUserTest() {
		test = extent.startTest("validateCartUserTest");
		LoginPage loginPage = new LoginPage(driver, test);
		BaseHomePage homePage = loginPage.login(sw.get_Data("standard_user"), sw.get_Data("password"));
		assertTrue(homePage.validateCart(), test);
		homePage.verifyLogout();
		if(homePage.validateCart())
		{
			test.log(LogStatus.PASS, "validateCartUserTest pass");
		}
		else
		{
			test.log(LogStatus.PASS, "validateCartUserTest failed");
		}
		
		extent.endTest(test);
	}
	
}
