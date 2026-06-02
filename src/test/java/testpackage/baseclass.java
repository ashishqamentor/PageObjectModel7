package testpackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.checkoutpage;
import pages.dashboard;
import pages.loginpage;

public class baseclass 
{
	public WebDriver w; //null
	public dashboard d;
	public checkoutpage c ;
	public loginpage l;

	@BeforeTest
	public void launch() throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/config.properties");
		Properties p = new Properties();
		p.load(fis);
		String browsername =p.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w= new ChromeDriver(op);
		}
		if(browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("inprivate");
			w= new EdgeDriver(op);			
		}	
		
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	
		d = new dashboard(w);
		c= new checkoutpage(w);
		l= new loginpage(w);
			
	}	
	
	//  person 1 changes 
	public ExtentReports extentreportobj()
	{
		ExtentSparkReporter  reporter = new ExtentSparkReporter("./report/mytest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	
	@AfterTest
	public void terminate()
	{
		w.quit();
	}
	
}
