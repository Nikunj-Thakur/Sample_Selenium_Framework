package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username=By.xpath("//input[@id='user_email']");
	
	By password=By.xpath("//input[@id='user_password']");
	
	By loginbtn=By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getuserName() {
		return driver.findElement(username);
	}

	public WebElement getpassWord() {
		return driver.findElement(password);
	}
	
	public WebElement getloginBtn() {
		return driver.findElement(loginbtn);
	}

}
