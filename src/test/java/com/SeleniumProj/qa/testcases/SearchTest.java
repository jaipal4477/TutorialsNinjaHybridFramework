package com.SeleniumProj.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumProj.qa.base.Base;
import com.SeleniumProj.qa.pages.HomePage;
import com.SeleniumProj.qa.pages.SearchPage;

public class SearchTest extends Base{
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		loadPropertiesFile1();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("BrowserName"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.enterProduct(prop1.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfValidProduct());
	}
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterProduct(prop1.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfInvalidProduct());
		}
}
