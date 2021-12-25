package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onFinish(ITestContext arg0) {
		extent.flush();
	}

	public void onStart(ITestContext arg0) {}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}

	public void onTestFailure(ITestResult arg0) {
		extentTest.get().fail(arg0.getThrowable());
		WebDriver driver=null;
		String testMethodName=arg0.getMethod().getMethodName();
		try {
			driver=(WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {} 
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(testMethodName,driver), arg0.getMethod().getMethodName());
		} catch (IOException e) {}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		 test=extent.createTest(arg0.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult arg0) {
		extentTest.get().log(Status.PASS, "Test is Success");
		WebDriver driver=null;
		String testMethodName=arg0.getMethod().getMethodName();
		try {
			driver=(WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());
		} catch (Exception e) {} 
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(testMethodName,driver), arg0.getMethod().getMethodName());
		} catch (IOException e) {}
		
	}

}
