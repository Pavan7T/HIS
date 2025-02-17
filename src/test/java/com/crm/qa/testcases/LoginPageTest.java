package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println("Actual Title: " + title);
		System.out.println("Expected Title: " + title);
		Assert.assertEquals(title, "Login");
		testcaseSuccesful();
	}

	@Test(priority = 2, enabled = false)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = homePage.verifyHomePageTitle();
		System.out.println("Actual Title: " + title);
		System.out.println("Expected Title: " + title);
		Assert.assertEquals(title, "Home");
		testcaseSuccesful();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
