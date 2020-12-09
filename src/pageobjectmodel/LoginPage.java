package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="email")
	WebElement name;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(how=How.XPATH, using="//button[@name='login']")
	WebElement button;
	
	public HomeP login(String uname, String password)
	{
		name.sendKeys(uname);
		pass.sendKeys(password);
		button.click();
		return new HomeP(driver);
		
	}
	
	
	
	

}
