package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Threedimensionalelement {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	driver.get("https://www.indiatoday.in/");
	
	System.out.println(driver.findElement(By.xpath("//marquee//a")).getText());
	
	List<WebElement>lists=driver.findElements(By.xpath("//div[@class='swiper-container swiper-container-cube swiper-container-3d swiper-container-horizontal']//li"));
	
	System.out.println("Äm I taking time to stream");
	lists.stream().forEach(x->System.out.println(x.getText()));
	}

}
