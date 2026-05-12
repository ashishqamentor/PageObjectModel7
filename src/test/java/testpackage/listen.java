package testpackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;

public class listen extends baseclass implements ITestListener {
	
	ExtentReports extent = extentreportobj();
	ExtentTest test ;
	ThreadLocal<ExtentTest> thread= new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("test starting");
		String testname = result.getMethod().getMethodName();
		test= extent.createTest(testname);
		thread.set(test);
		thread.get().info("this is my first automation extent report");

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("test success");
		thread.get().pass("test pass successfully");
				
		try {

			String testname = result.getMethod().getMethodName();
			
			w = (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			TakesScreenshot tc = (TakesScreenshot) w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
	        String formattedDate = now.format(formatter);
			File dest = new File("./screenshot/"+testname+"_"+formattedDate+".png");
			Files.copy(src, dest);
			
			String filepath = dest.getAbsolutePath();			
			thread.get().addScreenCaptureFromPath(filepath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent.flush();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("test failed");
		thread.get().fail("test Failed successfully");
		thread.get().fail(result.getThrowable());
		
		try {
			
			String testname = result.getMethod().getMethodName();
			
			w = (WebDriver) result.getTestClass().getRealClass().getField("w").get(result.getInstance());
			TakesScreenshot tc = (TakesScreenshot) w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			
			LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
	        String formattedDate = now.format(formatter);
			File dest = new File("./screenshot/"+testname+"_"+formattedDate+".png");
			Files.copy(src, dest);
			
			String filepath = dest.getAbsolutePath();			
			thread.get().addScreenCaptureFromPath(filepath);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		extent.flush();
	}

}
