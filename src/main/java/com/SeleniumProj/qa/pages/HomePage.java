package com.SeleniumProj.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement clickSearchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void myAccountMenu() {
		myAccountDropMenu.click();
	}
	public void clickloginOption() {
		loginOption.click();
	}
	public void clickRegisterOption() {
		registerOption.click();
	}
	public void enterProduct(String productName) {
		searchBoxField.sendKeys(productName);
	}
	public void clickOnSearchButton() {
		clickSearchButton.click();
	}
}
