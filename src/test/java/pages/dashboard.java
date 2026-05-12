package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboard 
{

	WebDriver w;  // null
	
	@FindBy(xpath = "//input[@type='search']")WebElement search;
	@FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")WebElement add;
		
	public dashboard(WebDriver w2) 
	{
		this.w=w2;		
		PageFactory.initElements(w, this);
	}

	public void addtokart() throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(1);
		int rowcount = sh.getLastRowNum();
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row =sh.getRow(i+1);
			String veg= row.getCell(0).getStringCellValue();
			search.sendKeys(veg);
			Thread.sleep(2000);
			add.click();
			search.clear();
		}
		
	}
	
	
	
}
