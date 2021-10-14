package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Carouselhandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		 ChromeOptions opt=new ChromeOptions();
		 opt.addArguments("--disable-notifications");
		 WebDriver driver=new ChromeDriver(opt);
		 driver.get("https://www.flipkart.com");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		 //System.out.println(driver.findElement(By.xpath("//h3[.='Recommended for you']")).isDisplayed());
		 List<WebElement>items=driver.findElements(By.xpath("//div[@data-tracking-id='Deals of the Day']//div[@class='_3YgSsQ']"));
		 System.out.println(items.size());
		while(driver.findElement(By.xpath("(//div[@class='_2kgArB _2CP_Bu'])[1]")).isDisplayed())
		{
		 for(int i=0;i<items.size();i++)
		 {
			 System.out.println(items.get(i).getText());
		 }
		 driver.findElement(By.xpath("(//div[@class='_2kgArB _2CP_Bu'])[1]")).click();
		 }
		
		 
	}

}
