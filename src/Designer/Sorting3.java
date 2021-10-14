package Designer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sorting3
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
	 Thread.sleep(7000);
	 //driver.switchTo().frame("stonlyWidgetParams_{\"hostOrigin\":\"https://test-designer.lovethat.design\",\"widgetRuleId\":5464,\"autoResizable\":false,\"compact\":false}");
	 driver.findElement(By.xpath("//div[@aria-label='Close Stonly widget']")).click();
	 //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div"));
	 Thread.sleep(2000);
	 driver.findElement(By.id("headNavProjects")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//mat-select[@aria-label='Items per page:']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//mat-option/span[.=' 100 ']")).click();
	 
	 //Fetch the elements as it is 
	 
	String sortvalue[]={"ascending","descending"};
	
	for(String s: sortvalue)
	{
	 try 
	 {
		 driver.findElement(By.xpath("//th[@aria-sort='"+s+"']"));
	 }
	 catch(Exception e)
	 {
		 try {
			 driver.findElement(By.xpath("(//div[@class='mat-sort-header-indicator ng-trigger ng-trigger-indicator'])[2]")).click();
			 driver.findElement(By.xpath("//th[@aria-sort='"+s+"']"));
		     }
		 
		 catch(Exception e1)
		 {
			 driver.findElement(By.xpath("(//div[@class='mat-sort-header-indicator ng-trigger ng-trigger-indicator'])[2]")).click();
		 }
	 }
	 
	 Thread.sleep(4000);
	 List<WebElement> project_names =driver.findElements(By.xpath("//table//td[3]"));
     ArrayList<String>obtainedList =new ArrayList<String>(project_names.size());
	 
	 
	 for(WebElement e: project_names)
	 {

		 obtainedList.add(e.getText());
	 }
	 
	 System.out.println("******************");
	 System.out.println("Sorting using application "+obtainedList);
	 
     ArrayList<String>sortedList =new ArrayList<String>(project_names.size());
	 
	 for(String e: obtainedList)
	 {
		 sortedList.add(e);
	 }
	 
    // Collections.sort(sortedList,String.CASE_INSENSITIVE_ORDER);
	 if (s.equals("ascending"))
	 {
		 Collections.sort(sortedList,String.CASE_INSENSITIVE_ORDER);
	 }
	 else if(s.equals("descending"))
	 {
	 sortedList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
	 }
	 System.out.println("\n******************");
	 System.out.println("Verifying sorting using java function " +sortedList);
	 
	 
	 if (sortedList.equals(obtainedList))
	 {
		 System.out.println("List is sorted in "+s+" order");
	 }
	 else
	 {
			/*
			 * //Collections.sort(obtainedList,Collections.reverseOrder());
			 * Collections.reverse(sortedList);
			 * System.out.println("After reversing "+sortedList); if
			 * (sortedList.equals(obtainedList)) {
			 * System.out.println("List is sorted in descending order"); } else {
			 * System.out.println("List is not sorted in any order"); }
			 */
		 System.out.println("List is not sorted in "+s+" order");
	}

}
}
}
