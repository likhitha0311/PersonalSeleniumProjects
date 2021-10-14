package Designer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Worldpopulationlive
{
@Test
public void world_population_live_count() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://populationmatters.org/population-numbers?gclid=CjwKCAjwieuGBhAsEiwA1Ly_nUJK8gx8pmH2W0h2bvg27IKk2aCD6eeqSFMEB68-O7tDgE3HCl1RhRoC2uYQAvD_BwE");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 int i=10;
 while(i>0)
 {
 System.out.println(driver.findElement(By.id("worldpop")).getText());;
 Thread.sleep(1000);
 i=i-1;
 

}
}
}
