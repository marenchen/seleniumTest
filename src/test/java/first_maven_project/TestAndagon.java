package first_maven_project;

import org.junit.After; 
import org.junit.Before; 
import org.junit.Test;
import org.junit.Assert; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestAndagon {
	
	WebDriver wDriver;
	String sBaseUrl = "https://www.andagon.com/";
	
	@Before 
	public void setUp() throws Exception{ 
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe"); 
		wDriver = new ChromeDriver();
		wDriver.manage().window().maximize();
		wDriver.get(sBaseUrl);
	}
	
	
	@Test 
	public void test() throws Exception{ 
		WebDriverWait wait = new WebDriverWait(wDriver, 10);
		WebElement andagonLogo = wDriver.findElement(By.xpath("//img[@class='header__logo']"));
		andagonLogo.click();
		wait.until(ExpectedConditions.elementToBeClickable(wDriver.findElement(By.xpath("//img[@class='header__logo']"))));
		String currentUrl = wDriver.getCurrentUrl();
		Assert.assertEquals(sBaseUrl, currentUrl);
		
	}

	@After 
	public void tearDown(){ 
		//wDriver.quit(); 
	} 

}
