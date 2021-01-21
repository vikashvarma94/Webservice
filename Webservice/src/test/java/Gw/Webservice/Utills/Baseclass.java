package Gw.Webservice.Utills;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Baseclass {
	public static WebDriver driver;
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH_mm_ss");
	public static LocalDateTime now = LocalDateTime.now(); 
	
	@BeforeTest(alwaysRun = true)
  	public void suite() {  
	 ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports/"+dtf.format(now)+".html");
	    report = new ExtentReports(); 
	    report.attachReporter(reporter);
	    }
  
  @AfterMethod(alwaysRun =true)
  public void endtest(ITestResult result) throws IOException{
	  TakesScreenshot ts  = (TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  String path=System.getProperty("user.dir")+"//Screnshots/"+dtf.format(now)+".png";
	  File destination = new File(path);
	  FileUtils.copyFile(src, destination );
	  
	  if (result.getStatus() == ITestResult.FAILURE){
		  test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());	  
	  }
	  else {
		  test.pass("pass",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	  }
	  report.flush();
  }





  
}
