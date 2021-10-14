package Designer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class Slider 
{

	
	@Test(priority=1)
	public void slider() throws InterruptedException
	{
	    System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lovethatdesign.com/community/");
		driver.manage().window().maximize();
		WebElement ele =driver.findElement(By.xpath("//div[@class='mCSB_dragger_bar']"));
		Point p=ele.getLocation();
		System.out.println("Width is" +ele.getSize().width);
		System.out.println(p.getX());;
		System.out.println(p.getY());
		Actions move = new Actions(driver);
		move.dragAndDropBy(ele, (p.getX())*2,0).release().build().perform();
		Thread.sleep(5000);
		driver.quit();
	}

}
