package Designer;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Brokenlinks
{
@Test()
public void identifybrokenLinks()
{
	
	String url;
	int brokenlink=0;
	int validlink=0;
	int thirdparty=0;
	String homepage="https://www.lovethatdesign.com";
	HttpURLConnection ap = null;
    int respCode = 200;
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(homepage);
	List<WebElement>links=driver.findElements(By.tagName("a"));
	System.out.println("count of links"+links.size());
	
	Iterator<WebElement>it=links.iterator();
	while(it.hasNext())
	{
		url=it.next().getAttribute("href");
	    System.out.println(url);
	    if(url.isEmpty()|| url==null)
	    {
	    	System.out.println("ä tag does not contain any href");
	    }
	    else if(!url.startsWith(url))
	    {
	    	System.out.println("Third party website");
	    	thirdparty++;
	    }
	    else
	    {
	    	try {
	    		ap=(HttpURLConnection)(new URL(url).openConnection());
	    		ap.setRequestMethod("HEAD");
	    		ap.connect();
	    		respCode=ap.getResponseCode();
	    		 if(respCode >= 400)
	    		 {
	                    System.out.println(url+" is a broken link");
	                    brokenlink++;
	                }
	                else
	                {
	                    System.out.println(url+" is a valid link");
	                    validlink++;
	                }
	    	}
	    	catch (MalformedURLException e) 
	    	{
              
                e.printStackTrace();
            } catch (IOException e) 
	    	{
              
                e.printStackTrace();
	    }
	
	    }
	
	
}
	System.out.println("Third party links" +thirdparty);
	System.out.println("Valid links"+validlink);
	System.out.println("Broken links"+brokenlink);
}
}
