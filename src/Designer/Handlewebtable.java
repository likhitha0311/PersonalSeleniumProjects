package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handlewebtable {

	public static void main(String[] args) throws InterruptedException 
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
		 List<WebElement>rows=driver.findElements(By.xpath("//table//tbody/tr"));
		 System.out.println("No of rows"+rows.size());
		 for (int i=0;i<rows.size();i++)
		 {
		 List<WebElement>columns=rows.get(i).findElements(By.tagName("td"));
		 System.out.println("No of rows"+columns.size());
		 for (int j=0;j<columns.size();j++)
		 {
		  String columntext=columns.get(j).getText();
		  System.out.println("Data in row"+i+"column" +j+ "is"+columntext);

	}

}
	}
}
