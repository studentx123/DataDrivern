package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propetym {
	
	static Properties p;
	
	public static String url()
	{
		return p.getProperty("url").toString();
	}
	
	public static String bname()
	{
		return p.getProperty("bname").toString();
	}
	static
	{
		try {
		File f=new File("./Files/property.prop");
		
			FileInputStream fi=new FileInputStream(f);
	
		 p=new Properties();
		p.load(fi);
		
		
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	

}
