package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{

	WebDriver w;
	@FindBy(css = "#user-name")WebElement user;
	@FindBy(css = "#password")WebElement pass;
	@FindBy(css = "#login-button")WebElement loginbutton;
	
	public loginpage(WebDriver w2) 
	{
		this.w=w2;
		PageFactory.initElements(w, this);
	}

	public void dologin(String username, String password, String expurl) throws Exception
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		loginbutton.click();
		Thread.sleep(2000);
		String acturl= w.getCurrentUrl();
		assertEquals(acturl, expurl);
			
	}
}
