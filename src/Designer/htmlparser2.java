package Designer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jsoup.Jsoup;

public class htmlparser2 
{
	static String latestfilegenerated=null;
	static String packagename;
	
static int infocount=0;
static int  errorcount=0;
static int fatalcount=0;
static int Total_cases=0;

	public static void main(String args[]) throws IOException
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
		
		String innerHtml = Jsoup.parse(file,"UTF-8").select("tr").html();
		
		// To break the sentence in words
		String []s = innerHtml.split(" ");
		
		for (String temp :s)
		{ 
			System.out.println(temp);
			if(temp.contains("category"))
			{
				
				int startindex=temp.indexOf(">");
				int endindex=temp.indexOf(".");
				packagename=temp.substring(startindex+1, endindex);;
				break;
			}
		}
        for (String temp :s)
		{
			
			if (temp.contains("INFO"))
			{
				infocount++;

			}

			else if(temp.contains("ERROR"))

			{
				errorcount++;

			}
			else if(temp.contains("FATAL"))
			{
				fatalcount++;
			}

		}

		Total_cases=infocount+errorcount+fatalcount;
		System.out.println("No of passed test cases:"+infocount+"\nNo of failed test cases:"+errorcount+"\nNo of exceptions:"+fatalcount);

	/*try 
	{ 
        BufferedWriter out = new BufferedWriter(new FileWriter("test-output/Log4jresults/"+"Consolidated_"+latestfilegenerated)); 
        //out.write(infocount); 
        out.close(); 
    } 
    catch (IOException e) 
	{ 
        System.out.println("Exception Occurred" + e); 
    } 
		*/
	
		/*org.jsoup.nodes.Document doc = Jsoup.parse(file,"UTF-8");
		doc.body().addClass("body-styles-cls");
		doc.body().appendElement("div");
		doc.body().appendElement("div");
		System.out.println(doc.toString());
		
	*/
		
	  /* try 
		   {
            //define a HTML String Builder
            StringBuilder htmlStringBuilder=new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html><head><title><strong>"+packagename+"</strong></title></head>");
            //append body
            htmlStringBuilder.append("<body>");
            //append table
            htmlStringBuilder.append("<table border=\"1\" bordercolor=\"#000000\">");
            //append row
           // htmlStringBuilder.append("<tr><td><b>TestId</b></td><td><b>TestName</b></td><td><b>TestResult</b></td></tr>");
            //htmlStringBuilder.append("<tr><td>002</td><td>Logout</td><td>Passed</td></tr>");
            //append row
            htmlStringBuilder.append("<h2>"+packagename+"</h2>");
            htmlStringBuilder.append("<tr><td>Number of Failed Test Cases</td><td>"+errorcount+"</td></tr>");
            //append row
           
            htmlStringBuilder.append("<tr><td>Number of Passed Test Cases</td><td>"+infocount+"</td></tr>");
            htmlStringBuilder.append("<tr><td>Script Failures</td><td>"+fatalcount+"</td></tr>");
            htmlStringBuilder.append("<tr><td>Total number of test cases executed</td><td>"+Total_cases+"</td></tr>");
            //close html file
            htmlStringBuilder.append("</table></body></html>");
		
            Htmlparser.WriteToFile(htmlStringBuilder.toString(),"test-output/Log4jresults/"+"Consolidated_"+packagename+"_"+latestfilegenerated);
	        } 
		   catch (IOException e) 
		   {
	            e.printStackTrace();
	        }
		   
	 */


	//Create blank workbook
    XSSFWorkbook workbook = new XSSFWorkbook();
    
    //Create a blank sheet
    XSSFSheet spreadsheet = workbook.createSheet( " Module Results ");

    //Create row object
    XSSFRow row;

    //This data needs to be written (Object[])
  Map<String, Object[]> resultinfo = new TreeMap < String, Object[]>();
    
    //resultinfo.put("Number of Failed Test Cases", new Object[]{errorcount});
    //resultinfo.put("Number of Passed Test Cases", new Object[]{infocount});
  
  resultinfo.put("1", new Object[]{"Number of Failed Test Cases",errorcount});
  resultinfo.put("2", new Object[]{"Number of Passed Test Cases",infocount});
  resultinfo.put("3", new Object[]{"Script Failures",fatalcount});
 resultinfo.put("4", new Object[]{"Total Number of  Test Cases Executed",Total_cases});
 resultinfo.put("5", new Object[]{packagename});
    
    Set < String > keyid = resultinfo.keySet();
    int rowid = 0;
    
    for (String key : keyid) 
    {
        row = spreadsheet.createRow(rowid++);
        Object [] objectArr = resultinfo.get(key);
        int cellid = 0;
        
        for (Object obj : objectArr){
           XSSFCell cell = row.createCell(cellid++);
           cell.setCellValue(obj.toString());
        }
     }
	
	
	 /*public static void WriteToFile(String fileContent, String fileName) throws IOException 
	   {
		   
		   OutputStream outputStream = new FileOutputStream("test-output/Log4jresults/"+"Consolidated_"+packagename+"_"+latestfilegenerated);
	        Writer writer=new OutputStreamWriter(outputStream);
	        writer.write(fileContent);
	        writer.close();
	   }
	  
*/
	
	FileOutputStream out = new FileOutputStream(new File("test-output\\Writesheet.xlsx"));
	      
	      workbook.write(out);
	      out.close();
}
}
