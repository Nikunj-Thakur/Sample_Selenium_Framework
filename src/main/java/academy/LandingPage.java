package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;

	By popUp=By.xpath("//div[@class='sumome-react-svg-image-container']");
	By loginLink=By.partialLinkText("Login");
	By courseTitle=By.xpath("//*[@id='content']/div/div/h2");
	By navBar=By.xpath("//nav[@class='navbar-collapse collapse']");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getpopUp() {
		return driver.findElement(popUp);
	}
	
	public WebElement getloginLink() {
		return driver.findElement(loginLink);
	}
	
	
	public WebElement getcourseTitle() {
		return driver.findElement(courseTitle);
	}
	
	public WebElement getnavBar() {
		return driver.findElement(navBar);
	}
	

}
