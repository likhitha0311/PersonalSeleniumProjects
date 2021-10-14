package Designer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) 
	
	{
		
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("https://www.w3schools.com/html/html_tables.asp");
driver.manage().window().maximize();

List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
System.out.println("Row size is " +rows.size());

for(int i=1;i<rows.size();i++)
	
{
	List<WebElement>columns =rows.get(i).findElements(By.tagName("td"));
	for(int j=0;j<columns.size();j++)
	{
		String text =columns.get(j).getText();
		if (text.equals("Helen Bennett"))
		{
			System.out.println(text+ "row no is "+(i+1)+ "Column  no is"+(j+1));
			break;
		}
		
	}
}


	
int columnno =driver.findElements(By.xpath("//table[@id='customers']//tr//th")).size();
	
	for(int i=1;i<rows.size();i++)
	{
		for(int j=1;j<=columnno;j++)
		{
			String text1=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText(); //1st row has th inside it instead of td, so we are starting iteration from i+1. But if I 
			//make i<=rows.size(), then it will itearate up to tr[8] whuch will throw no such element exception.
			if (text1.equals("Helen Bennett"))
			{
				System.out.println(text1+ "row no is "+(i+1)+ "Column  no is"+(j));
				break;
			}
		}
	}

}
}
