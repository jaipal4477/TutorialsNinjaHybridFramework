package com.SeleniumProj.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Tutorials Ninja Test Automatio Result");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(spark);
		
		Properties config_prop = new Properties();
		File config_file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\SeleniumProj\\qa\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(config_file);
		config_prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL: ", config_prop.getProperty("url"));
		extentReport.setSystemInfo("Browser: ", config_prop.getProperty("BrowserName"));
		extentReport.setSystemInfo("Email", config_prop.getProperty("Email"));
		extentReport.setSystemInfo("Password", config_prop.getProperty("Password"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("java version", System.getProperty("java.version"));
		
		return extentReport;
	}
}
