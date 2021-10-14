package Designer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Covidgraph {

	public static void main(String[] args) throws InterruptedException
	
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/search?q=covid+cases+in+India&oq=covid+cases+in+India&aqs=chrome..69i57j0i271l3j69i61.5067j0j7&sourceid=chrome&ie=UTF-8");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		List<WebElement>cases=driver.findElements(By.xpath("(//*[name()='svg' and @class='uch-psvg'])[1]//*[local-name()='rect']"));
		
		Actions act=new Actions(driver);
		
		//cases.stream().forEach(x -> act.moveToElement(x).perform());
		
		for (WebElement e: cases)
		{
			act.moveToElement(e).perform();
			String text=driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(text);
			System.out.println("********");
		}
		

	}

}
