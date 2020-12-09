package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeP {
	WebDriver driver;
	public HomeP(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		WebDriverWait w=new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(n));
	}
	@FindBy(how=How.XPATH,using="//span[text()='Appu Es']")
	WebElement n;

	public Logout hm()
	{
	
		System.out.println(	n.getText());
		return new Logout(driver);
		
	}
	
	

}
