package com.qapitol.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
private static ExtentReports extent;
	
	public static ExtentReports getInstance()  {
		
		if (extent == null) {
			String reportPath = System.getProperty("user.dir")+"\\test-output\\extent.html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			
			try {
				sparkReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportConfig.xml"));
				extent = new ExtentReports();
				//extent.attachReporter(sparkReporter);
			} 
			catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return extent;
	}

}
