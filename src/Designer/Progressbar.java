package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Progressbar 
{
	
@Test()
public void progressbar() throws InterruptedException
{
	
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://qa2.lovethatdesign.com/?ign_skip=3684779303984");
	driver.manage().window().maximize();
	List<WebElement>progressbars=driver.findElements(By.xpath("//span[starts-with(@class,'swiper-pagination-bullet')]"));
	int count=progressbars.size();
	System.out.println(count);
	for(int i=0;i<count;i++)
	{
		progressbars.get(i).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//span[@class='swiper-pagination-bullet swiper-pagination-bullet-active']")).getText());;
	}
	

	
	
}
}
