package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;

public class LoginTest extends Base{
	WebDriver driver;
	private static  Logger log=LogManager.getLogger(VerifyCourseTest.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the URL");
		Thread.sleep(10000);
		LandingPage lanp=new LandingPage(driver);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lanp.getpopUp());
		log.info("Pop-up is closed");
		lanp.getloginLink().click();
	}
	
	@Test(dataProvider="getData")
	public void login(String Username,String Password,String Text) {
		LoginPage logp=new LoginPage(driver);
		logp.getuserName().sendKeys(Username);
		logp.getpassWord().sendKeys(Password);
		System.out.println(Text);
		logp.getloginBtn().click();
		log.info("Clicked on Login Button successfully");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object [][] data=new Object[2][3];
		data[0][0]="restricteduser@gmail.com";
		data[0][1]="restricteduserpassword";
		data[0][2]="restricteduser@gmail.com";
		
		data[1][0]="non-restricteduser@gmail.com";
		data[1][1]="non-restricteduserpassword";
		data[1][2]="non-restricteduser@gmail.com";
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.debug("Driver is closed");
	}
	

}
