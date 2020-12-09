package testcasepackage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Basepacakge.BaseClass;
import pageobjectmodel.HomeP;
import pageobjectmodel.LoginPage;
import pageobjectmodel.Logout;
import properties.Propetym;
import utilitypackage.Utils;
public class TestCases extends BaseClass {
	WebDriver driver;
	@Parameters({"bname"})
	@BeforeMethod
	public void bmethod(String bname)
	{
		this.driver=browserstart(bname);
		
		driver.get(Propetym.url());
	}
	@Test(dataProvider="test",dataProviderClass=utilitypackage.Utils.class,retryAnalyzer = analyser.RetryAnalyzers.class)
	public void test1(String uname, String pass)
	{
		LoginPage p=new LoginPage(driver);
	HomeP g=p.login(uname, pass);
	Logout l=g.hm();
	l.Lo();
		System.out.println(Thread.currentThread());
	}
	
	@AfterMethod
	public void amethod(ITestResult r)
	{
		if(r.getStatus()==ITestResult.SUCCESS)
		{
			try {
				Utils.filewriting("Pass");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				Utils.filewriting("Fail");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.screenShot(driver);
		}
		
	}

}
