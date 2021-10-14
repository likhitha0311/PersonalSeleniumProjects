package Designer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streamfilterexample {

	public static void main(String[] args)
	{
		List<String> listitems=Arrays.asList("Pinky","Civilization","Mat","Stream");
		System.out.println(listitems);

		listitems.forEach(ele -> System.out.println(ele));
		
		Predicate<String> func = x-> !x.equals("Mat");
		
		System.out.println(func.test("Matin"));;
		
		/*Single condition */
		
		List<String>newlist=listitems.stream().filter(x-> !x.equals("Mat")).collect(Collectors.toList());
		
		//listitems.stream().filter(func.test("Matin")).collect(Collectors.toList());
		
		//Print using forEach loop-method1
		
		newlist.forEach(ele1->System.out.println(ele1));;
		
		//Print using forEach loop-method2
		newlist.forEach(System.out::println);
		
		/* Single condition with find any and or else*/
		List<Customer>customerlist=Arrays.asList(new Customer("sweety",25),
				new Customer("June",23),
				new Customer("sweety",225),
				new Customer("James",26));
		
		customerlist.get(0).getName();//Customerlist variable consists of entire list elements, we cant get individual method s using that, so I am accessing individula list element using index(which is object of Customer class and accessing their names using getName)
		
		Customer c=customerlist.stream().filter(x-> "sweety".equals(x.getName())).findAny().orElse(null);//findAny will perform operation on 1 element and rreturns 1 element only so It will return 1 customer object
		
		System.out.println(c.getName()+c.getAge());
		
		/*Multiple condition with find any and or else */
		Customer c1=customerlist.stream().filter(x-> "sweety".equals(x.getName()) && 225==x.getAge()).findAny().orElse(null);
		
		System.out.println(c1.getName()+c1.getAge());
		
	}
	

}
