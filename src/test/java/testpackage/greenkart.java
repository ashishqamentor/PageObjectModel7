package testpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.checkoutpage;
import pages.dashboard;

public class greenkart extends baseclass
{
	
	@Test
	public void endtoendjourney() throws Exception
	{
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		d.addtokart();		
		c.docheckout();
			
	}

}
