package Designer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Maxvalueincolumn {

	public static void main(String[] args) throws InterruptedException {
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
		 double max=0;
		 for(int i=1;i<rows.size();i++)
		 {
			 String text=driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[5]")).getText();
			 text=text.replaceAll(" hrs", "");
			 double value=Double.parseDouble(text);
			 if(value>max)
			 {
				 max=value;
			 }
			 
		 }
		 System.out.println("Maximum value is "+max);

	}

}
