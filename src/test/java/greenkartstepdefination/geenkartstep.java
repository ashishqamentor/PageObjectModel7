package greenkartstepdefination;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testpackage.baseclass;

public class geenkartstep extends baseclass
{

	@Given("user is on greenkart site.")
	public void opensite() throws Exception
	{
		launch();
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}	
	
	@When("user add vegitable in the kart.")
	public void addtokart() throws Exception
	{
		d.addtokart();	
	}
	
	@And("do checkout journey")
	public void checkout()
	{
		c.docheckout();
	}
	
	@Then("success messages is displayed and image is captured.")
	public void screenshot() throws IOException
	{
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String formattedDate = now.format(formatter);
		
		File dest = new File("./screenshot/greenkart_"+formattedDate+".png");
		Files.copy(src, dest);
		
		w.quit();
		
	}
	
}
