package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	
	WebDriver driver;
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("in logout");
		
	}

	@FindBy(how=How.XPATH, using="//div[@aria-label=\"Account\"]")
	WebElement hl;
	
	@FindBy(how=How.XPATH, using="//div[@class=\"b20td4e0 muag1w35\"]/child::div[4]")
	WebElement l;
	
	
	public void Lo()
	{
		hl.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.click();
	}
	
	
}
