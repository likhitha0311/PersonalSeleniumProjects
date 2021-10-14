package Designer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activeslider {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		int i=5;
		List<String>newlist= new ArrayList<String>();
		
		while(i!=0)
		{
		String hyperlink =driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-center carousel-slide']//picture//img")).getAttribute("src");
		newlist.add(hyperlink);
	    System.out.println(hyperlink);
		Thread.sleep(7000);
		System.out.println(i);
		i--;

	    }
		
		for(int j=1; j<newlist.size();j++)
		{
			if(newlist.get(j-1)!= newlist.get(j))
			{
				System.out.println("Ïmages are not same");
			}
			else
			{
				System.out.println("Ïmages are same");
			}
		}

}
}
