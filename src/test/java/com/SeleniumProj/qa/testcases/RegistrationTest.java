package com.SeleniumProj.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumProj.qa.Utils.Utils;
import com.SeleniumProj.qa.base.Base;
import com.SeleniumProj.qa.pages.AccountSuccessPage;
import com.SeleniumProj.qa.pages.HomePage;
import com.SeleniumProj.qa.pages.RegistrationPage;

public class RegistrationTest extends Base {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		loadPropertiesFile1();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("BrowserName"));
		HomePage homePage = new HomePage(driver);
		homePage.myAccountMenu();
		homePage.clickRegisterOption();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void verifyRegistreringAccountWithMandatoryFields(String firstName, String lastName, String emailAddress, String enterTelephone, String enterPassword, String confirmPassword)
	{
		RegistrationPage registrationPage=new RegistrationPage(driver);
		registrationPage.enterFirstName(firstName);
		registrationPage.enterLastName(lastName);
		registrationPage.enterEmailAddress(emailAddress);
		registrationPage.enterTelephone(enterTelephone);
		registrationPage.enterPassword(enterPassword);
		registrationPage.enterConfirmPassword(confirmPassword);
		registrationPage.chooseAgree();
		registrationPage.selectContinue();
		/*driver.findElement(By.id("input-firstname")).sendKeys("a");
		driver.findElement(By.id("input-lastname")).sendKeys("b");
		driver.findElement(By.id("input-email")).sendKeys(Utils.generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("12245");
		driver.findElement(By.id("input-password")).sendKeys("1245");
		driver.findElement(By.id("input-confirm")).sendKeys("1245");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		AccountSuccessPage asp=new AccountSuccessPage(driver);
		
		String str = asp.accountSuccessPageHeading();
		Assert.assertEquals(str, prop1.getProperty("accountSuccessfullyCreatedHeading"));
		
		}
	@Test(priority=2)
	public void verifyRegisteringAccountWithAllFields(String firstName, String lastName, String emailAddress, String enterTelephone, String enterPassword, String confirmPassword)
	{
		RegistrationPage registrationPage=new RegistrationPage(driver);
		registrationPage.enterFirstName(firstName);
		registrationPage.enterLastName(lastName);
		registrationPage.enterEmailAddress(emailAddress);
		registrationPage.enterTelephone(enterTelephone);
		registrationPage.enterPassword(enterPassword);
		registrationPage.enterConfirmPassword(confirmPassword);
		registrationPage.selectNewsLetter();
		registrationPage.chooseAgree();
		registrationPage.selectContinue();
		
		AccountSuccessPage asp=new AccountSuccessPage(driver);	
		String str = asp.accountSuccessPageHeading();
		Assert.assertEquals(str, prop1.getProperty("accountSuccessfullyCreatedHeading"));	
		}
	@Test(priority=3)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		RegistrationPage registrationPage=new RegistrationPage(driver);
		registrationPage.selectContinue();
		
		
		String actualPrivacyPolicyWarning = registrationPage.retrievePrivacyPolicyWarning();
		Assert.assertEquals(actualPrivacyPolicyWarning, prop1.getProperty("privacyPolicyWarning"));
		
		String firstNameWarning = registrationPage.retrieveFirstNameWarning();
		Assert.assertEquals(firstNameWarning, prop1.getProperty("firstName"));
		
		String lastNameWarning = registrationPage.retrieveLastNameWarning();
		Assert.assertEquals(lastNameWarning, prop1.getProperty("lastName"));
		
		String emailWarning = registrationPage.retrieveEmailWarning();
		Assert.assertEquals(emailWarning, prop1.getProperty("emailWarning"));
		
		String telephoneWarning = registrationPage.retrieveTelephoneWarning();
		Assert.assertEquals(telephoneWarning, prop1.getProperty("telephoneWarning"));
		
		String passwordWarning = registrationPage.retrivePasswordWarning();
		Assert.assertEquals(passwordWarning, prop1.getProperty("passwordWarning"));
		
		
	}
}
