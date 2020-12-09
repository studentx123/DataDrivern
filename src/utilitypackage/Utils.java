package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Utils {
	@DataProvider(name="test")
	public Object[][] excelFileReader() throws Exception
	{
		File f=new File("./Files/Test.xlsx");

		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet st=wb.getSheet("Sheet1");

		int r=st.getPhysicalNumberOfRows();

		XSSFRow row=st.getRow(0);
		int c=row.getPhysicalNumberOfCells();

		System.out.print(r+""+c);

		Object a[][]=new Object[r-1][c-2];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c-2;j++)
			{
				String c1=st.getRow(i).getCell(j).getStringCellValue();
				if(c1.equalsIgnoreCase("username"))
				{
					break;
				}
				else
				{
					a[i-1][j]=st.getRow(i).getCell(j).getStringCellValue();
					System.out.println(a[i-1][j]);
				}
			}
		}

		return a;

	}

	static int i=0;
	public static void filewriting(String R) throws Exception
	{
		File f=new File("./Files/Test.xlsx");
		FileInputStream fi=new FileInputStream(f);

		XSSFWorkbook wbb=new XSSFWorkbook(fi);
		XSSFSheet sh=wbb.getSheet("Sheet1");

		XSSFRow row=sh.getRow(0);
		int rn=sh.getPhysicalNumberOfRows();

		for(i=i+1;i<rn;)
		{
			String value=sh.getRow(i).getCell(2).getStringCellValue();
			if(value.equalsIgnoreCase("tc"+i))
			{
				sh.getRow(i).createCell(3).setCellValue(R);
				FileOutputStream fo=new FileOutputStream(f);
				wbb.write(fo);
				break;
				
			}
			
		}

	}

	public static void screenShot(WebDriver driver)
	{
		TakesScreenshot sc=(TakesScreenshot)driver;
		
		File scr=sc.getScreenshotAs(OutputType.FILE);
		
		String TimeStamp=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		
		try {
			FileUtils.copyFile(scr, new File("./Screens/"+TimeStamp+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



}
