package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Yahoo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	driver.get("https://in.yahoo.com/?p=us");
	List<WebElement>lists=driver.findElements(By.xpath("//div[contains(@class,'ntk-filmstrip ')]//li//a"));
	
	
	for(WebElement listitem:lists)
	{
		//String href=listitem.getAttribute("href");
		//driver.get(href);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.CONTROL).click(listitem).perform();
		
	}
	


	}

}
