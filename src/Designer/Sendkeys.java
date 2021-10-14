package Designer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Sendkeys {

	@Test()
	public void method_send_keys()
	
	
	{
	
		//ChromeOptions chromeoptions=new ChromeOptions();
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		/****
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		***/
		driver.get("https://canvas-dev.lovethat.design/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("");
		
		
		
	}

}
