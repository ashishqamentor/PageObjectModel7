package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class checkoutpage
{	
	WebDriver w;
	@FindBy(xpath = "//a[@class='cart-icon']")WebElement carticon;
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")WebElement proceed;
	@FindBy(css = ".promoCode")WebElement promocode;
	@FindBy(css = ".promoBtn")WebElement apply;
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")WebElement placeorder;
	@FindBy(xpath = "//select")WebElement selectcountry;
	@FindBy(css=".chkAgree")WebElement checkbox;
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")WebElement finalproceed;
	
	public checkoutpage(WebDriver w2)
	{
		this.w=w2;
		PageFactory.initElements(w, this);
	}

	public void docheckout()
	{
		carticon.click();
		proceed.click();
		promocode.sendKeys("ashish");
		apply.click();
		placeorder.click();
		
		Select s = new Select(selectcountry);
		s.selectByVisibleText("India");
		checkbox.click();
		finalproceed.click();
	}
	
}
