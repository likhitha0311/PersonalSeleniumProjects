package Designer;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;


public class ExcelReport
{
static WebDriver driver;
static String latestfilegenerated=null;
static String packagename;

static int infocount=0;
static int  errorcount=0;
static int fatalcount=0;
static int Total_cases=0;
	public static void main(String[] args) throws IOException 
	{
		File folder = new File("test-output\\Log4jresults");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> Arraydate=new ArrayList<String>();
		
		for (int i = 0; i < listOfFiles.length; i++) 
		{
			if (listOfFiles[i].isFile()) 
			{
				String name=listOfFiles[i].getName();
				String []splitfilename=name.split("Test_Results_");
				String file_name=splitfilename[1].toString();
				String []datetime=file_name.split(".html");
				for(int k=0;k<datetime.length;k++)
				{
					Arraydate.add(datetime[0]);
				}

			} //System.out.println(Arraydate);
			Collections.sort(Arraydate, new Comparator<String>() 
			{
				DateFormat f = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
				@Override
				public int compare(String o1, String o2) 
				{
					try 
					{
						return f.parse(o1).compareTo(f.parse(o2));
					} 
					catch (Exception e) 
					{
						throw new IllegalArgumentException(e);
					}
				}
			});
		}
		System.out.println(Arraydate);

		String latest_file=Arraydate.get(Arraydate.size()-1);
		String latest_file_with_prefix="Test_Results_"+latest_file;
		System.out.println("latest_file_with_prefix is "+latest_file_with_prefix);

		for (int l = 0; l< listOfFiles.length; l++) 
		{

			String name=listOfFiles[l].getName();
			if(name.equals(latest_file_with_prefix+".html"))
			{
				latestfilegenerated=listOfFiles[l].getName();
				
				//System.out.println(latestfilegenerated);
				break;
			}
		}
		
		File file = new File("test-output/Log4jresults/"+latestfilegenerated);
		
		String  document1 = Jsoup.parse(file,"UTF-8").select("tr").html();
		
		Document doc=Jsoup.parse(document1);
		System.out.println(doc);
		System.out.println(doc.getElementsByTag("td"));;
		

	}
}


