package Designer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Product_Slider 
{
	@Test(priority=1)
	public void slider() throws InterruptedException
	{
	    System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lovethatdesign.com/brand/caimi-brevetti/product/oversize-lux/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement ele =driver.findElement(By.xpath("//div[@class='mCSB_dragger_bar']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		Point p=ele.getLocation();
		System.out.println("Width is" +ele.getSize().width);
		System.out.println(p.getX());;
		System.out.println(p.getY());
		Actions move = new Actions(driver);
		move.dragAndDropBy(ele, 500, 0).release().build().perform();;
		//move.dragAndDropBy(ele, (p.getX())*2,0).release().build().perform();
		//Thread.sleep(5000);
		//driver.quit();
	}
}
