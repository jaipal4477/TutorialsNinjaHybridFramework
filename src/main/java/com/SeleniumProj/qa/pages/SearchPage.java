package com.SeleniumProj.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(name="search")
	WebElement ValidProduct;
	
	@FindBy(name="search")
	WebElement InvalidProduct;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfValidProduct() {
		ValidProduct.isDisplayed();
		return displayStatusOfValidProduct();
	}
	public boolean displayStatusOfInvalidProduct() {
		InvalidProduct.isDisplayed();
		return displayStatusOfInvalidProduct();
	}
	
	
	
}
