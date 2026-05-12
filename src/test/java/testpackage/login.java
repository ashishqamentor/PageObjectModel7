package testpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.loginpage;

public class login extends baseclass
{

	@Test(dataProvider = "testdata")
	public void logintest(String username, String password,String expurl) throws Exception
	{
		w.get("https://www.saucedemo.com/");
		l.dologin(username,password,expurl);
	
	}
	
	@DataProvider(name = "testdata")
	public Object[][] mydata() throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		int colcount = sh.getRow(0).getLastCellNum();
		
		Object obj[][]= new Object[rowcount][colcount];
		for(int i =0;i<rowcount;i++)
		{
			XSSFRow row = sh.getRow(i+1);
			for(int j=0;j<colcount;j++)
			{
				obj[i][j]=row.getCell(j).getStringCellValue();
			}
					
		}
		return obj;	
		
	}
	
	
}
