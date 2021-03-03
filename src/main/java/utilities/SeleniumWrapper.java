package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.internal.DynamicGraph.Status;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class SeleniumWrapper {


	public static Properties prop = new Properties();
	public ExtentTest test;
	public WebDriver driver;
	public SeleniumWrapper(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public SeleniumWrapper() {
		// TODO Auto-generated constructor stub
	}

	public void clickElement(WebElement element,String elementName)
	{
		test.log(LogStatus.INFO, "clicking on element "+elementName);
		element.click();
	}
	public void sendKeys(WebElement element,String data,String elementName)
	{
		test.log(LogStatus.INFO, "sending to the element "+elementName);
		element.sendKeys(data);
	}
	public void sleep()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String get_Data(String Key)  
	{
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\utilities\\TestData.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = prop.getProperty(Key);
		return data;
	}


}
