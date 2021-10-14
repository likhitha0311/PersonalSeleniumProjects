package Designer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScrollWebElement
{
	@Test

	public void scroll() throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://canvas-dev.lovethat.design/auth/login");
		driver.findElement(By.id("can-email")).sendKeys("likhitha@28lightbulbs.com");
		driver.findElement(By.id("can-password")).sendKeys("28lightbulbs");
		driver.findElement(By.id("can-sign-in")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/project']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[.=' Add Project ']")).click();
		EventFiringWebDriver e=new EventFiringWebDriver(driver);
		e.executeScript("document.querySelector('ejs-sidebar[id=\"sidebar-menu\"]').scrollTop=800");
		driver.close();
		
		
		

	}

}
