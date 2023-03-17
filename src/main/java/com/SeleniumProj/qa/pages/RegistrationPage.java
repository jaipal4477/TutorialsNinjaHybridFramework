package com.SeleniumProj.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	@FindBy(name="agree")
	private WebElement agreeField;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement yesNewsletterOption;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	public void enterEmailAddress(String emailAddress) {
		emailAddressField.sendKeys(emailAddress);
	}
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	public void chooseAgree() {
		agreeField.click();
	}
	public void selectNewsLetter() {
		yesNewsletterOption.click();
	}
	public void selectContinue() {
		continueButton.click();
	}
	
	public String retrievePrivacyPolicyWarning() {
		privacyPolicyWarning.getText();
		return retrievePrivacyPolicyWarning();
	}
	public String retrieveFirstNameWarning() {
		firstNameWarning.getText();
		return retrieveFirstNameWarning();
	}
	public String retrieveLastNameWarning() {
		lastNameField.getText();
		return retrieveLastNameWarning();
	}
	public String retrieveEmailWarning() {
		emailAddressField.getText();
		return retrieveEmailWarning();
	}
	public String retrieveTelephoneWarning() {
		telephoneField.getText();
		return retrieveTelephoneWarning();
	}
	public String retrivePasswordWarning() {
		passwordField.getText();
		return retrivePasswordWarning();
	}
}
