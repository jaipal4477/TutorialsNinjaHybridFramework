package com.SeleniumProj.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties prop1;
	public void loadPropertiesFile()
	{
		prop = new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\SeleniumProj\\qa\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadPropertiesFile1()
	{
		prop1 = new Properties();
		File propFile1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\SeleniumProj\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream fis1=new FileInputStream(propFile1);
		prop1.load(fis1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		 driver.get("http://www.tutorialsninja.com/demo");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 
		return driver;
	}
	
}
