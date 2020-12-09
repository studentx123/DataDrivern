package analyser;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzers implements IRetryAnalyzer {
	
	int c=0;
	int maxcount=1;
	
	public boolean retry(ITestResult r)
	{
		if(c<maxcount)
		{
			maxcount++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	

}
