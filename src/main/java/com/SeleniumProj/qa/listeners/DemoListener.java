package com.SeleniumProj.qa.listeners;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoListener {

      static WebDriver driver;
      String browserName = "chrome";
      @BeforeMethod
      public void openBrowser(String browserName) {

 
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

      }

      @Test
      public void OpenSite() {

            driver.get("https://automationtestingmaterial.blogspot.in/");

      }

      @Test
      public void clickOnAdvanceJavaLink() {

            driver.findElement(By.linkText("Advance Java")).click();

      }

      @Test
      public void testToFail() {

            //System.out.println("This method is test to fail");
            String pageSource = driver.getPageSource();
            Assert.assertEquals(pageSource, pageSource.contains("abcd")); // Forcefully we will fail this                                                                                                    
      }

}