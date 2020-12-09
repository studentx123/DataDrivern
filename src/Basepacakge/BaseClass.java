package Basepacakge;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	//public WebDriver driver;
	public WebDriver browserstart(String name)
	{
		if(name.equalsIgnoreCase("Chrome"))
		{
			String s=System.getProperty("user.dir");
			System.out.println(s);
			System.setProperty("webdriver.chrome.driver",s+"/Driver/chromedriver.exe");
			Map <String, Object> pref=new HashMap<String, Object>();
			pref.put("profile.default_content_setting_values.notifications", 2);
			
			ChromeOptions co=new ChromeOptions();
			co.setExperimentalOption("prefs", pref);
			
			
			WebDriver driver=new ChromeDriver(co);
			return driver;
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			String s=System.getProperty("user.dir");
			System.out.println(s+"gecko");
			System.setProperty("webdriver.gecko.driver",s+"/Driver/geckodriver.exe");
			
			WebDriver driver=new FirefoxDriver();
			return driver;
		}
		else
		{
			System.out.println("Enter the valid driver name");
			return null;
		}
	}
	
	
	
	
	
	
	
	

}
