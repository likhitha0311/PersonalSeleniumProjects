package Designer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lambdaexpressions {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
List<String>countrynames= new ArrayList<String>();
countrynames.add("Singapore");
countrynames.add("Dubai");
countrynames.add("NewYork");

countrynames.stream().forEach(x-> System.out.println(x.toUpperCase()));

/*
Iterator<String>iterator=countrynames.iterator();

while(iterator.hasNext())
{
	System.out.println(iterator.next());
}

*/
ListIterator<String> l=countrynames.listIterator(countrynames.size());

while(l.hasPrevious())
{
	System.out.println(l.previous());
}

	}

}
