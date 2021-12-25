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
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.Base;

public class VerifyNavTest extends Base {
	
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
		
	}
	
	@Test
	public void navBar() throws IOException, InterruptedException {
	LandingPage lanp=new LandingPage(driver);
	Assert.assertTrue(lanp.getnavBar().isDisplayed());
	log.debug("Navigation bar is successfully verified");
	
}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.debug("Driver is closed");
	}
}

