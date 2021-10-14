package Designer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://qa2.lovethatdesign.com/?ign_skip=3684779303984");
	}

}
