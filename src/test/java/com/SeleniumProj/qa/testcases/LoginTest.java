package com.SeleniumProj.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumProj.qa.Utils.Utils;
import com.SeleniumProj.qa.base.Base;
import com.SeleniumProj.qa.pages.HomePage;
import com.SeleniumProj.qa.pages.LoginPage;

public class LoginTest extends Base{
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		loadPropertiesFile();
		loadPropertiesFile1();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("BrowserName"));
		HomePage homePage = new HomePage(driver);
		homePage.myAccountMenu();
		homePage.clickloginOption();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void verifyLoginWithValidCredentials(String email,String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.submitButton();
		
		//driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("12345");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());			
	}
	@Test(priority=2)
	 public void verifyLoginWithInvalidCredentials() {
		 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(Utils.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop1.getProperty("invalidPassword"));
		loginPage.submitButton();
		
		 //driver.findElement(By.id("input-email")).sendKeys("acv");
		 //driver.findElement(By.id("input-password")).sendKeys("ee");
		 //driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
	}
	 @Test(priority=3)
	 public void verifyLoginWithBlankCredentials() {
		 
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.submitButton();
		 
		 String warningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
	 }

}
