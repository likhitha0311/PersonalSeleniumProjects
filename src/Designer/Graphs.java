package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Graphs 
{
	
	@Test(priority=1)
	public void graph_Data() throws InterruptedException
	{
	 System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	 ChromeOptions opt=new ChromeOptions();
	 opt.addArguments("--disable-notifications");
	 WebDriver driver=new ChromeDriver(opt);
	 driver.get("https://test-designer.lovethat.design/");
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys("likhitha@28lightbulbs.com");
	 driver.findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys("Jar-Merc-binks");
	 driver.findElement(By.xpath("//button[.='Sign In']")).click();
	 Thread.sleep(10000);
	 //driver.switchTo().frame("stonlyWidgetParams_{\"hostOrigin\":\"https://test-designer.lovethat.design\",\"widgetRuleId\":5464,\"autoResizable\":false,\"compact\":false}");
	 driver.findElement(By.xpath("//div[@aria-label='Close Stonly widget']")).click();
	 //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div"));
	 driver.findElement(By.id("headNavProjects")).click();
	 Thread.sleep(7000);
	 driver.findElement(By.xpath("//mat-icon[@svgicon='inv-search']")).click();
	 driver.findElement(By.xpath("(//input[@data-placeholder='Search'])[2]")).clear();
	 driver.findElement(By.xpath("(//input[@data-placeholder='Search'])[2]")).sendKeys("remember");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("(//tr[1]/td[3])[1]")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.id("projectDetailsOverviewHeader")).click();
	 Thread.sleep(10000);
	 Actions act=new Actions(driver);
	 String verticalbars="//*[local-name()='svg']//*[name()='g' and @role='menuitem']";
	 List<WebElement>vertical=driver.findElements(By.xpath(verticalbars));
	 
	 
	 String textxpath="//*[local-name()='svg']//*[name()='g' and @role='tooltip']//*[name()='foreignObject']";
	 //List<WebElement>vertical=driver.findElements(By.xpath(verticalbars));
	 System.out.println("Total bars in the list " +vertical.size());
	 
	 for (WebElement e:vertical)
	 {
		 act.moveToElement(e).perform();
         Thread.sleep(1000);
         String text=driver.findElement(By.xpath(textxpath)).getText();
         System.out.println(text);
	 }
	 
	 
	 
	 
	 
}
}
