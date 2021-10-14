package Designer;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class windowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		 ChromeOptions opt=new ChromeOptions();
		 opt.addArguments("--disable-notifications");
		 WebDriver driver=new ChromeDriver(opt);
		 driver.get("https://test-designer.lovethat.design/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		// driver.findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys("likhitha@28lightbulbs.com");
		 //driver.findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys("Jar-Merc-binks");
		 //driver.findElement(By.xpath("//button[.='Sign In']")).click();
		 driver.get("https://www.naukri.com");
		 String window=driver.getWindowHandle();
		 Set<String> allWindows = driver.getWindowHandles();
	      Iterator<String> i = allWindows.iterator();
	      while(i.hasNext()){
	         String childwindow = i.next();
	         if(!childwindow.equalsIgnoreCase(window)){
	            driver.switchTo().window(childwindow);
	            System.out.println("The child window is "+childwindow);
	         } else {
	            System.out.println("There are no children");
	         }
	      }
	      //driver.quit();
	   }

	}


