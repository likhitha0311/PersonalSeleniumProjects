package Designer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streammapexample {

	public static void main(String[] args) 
	{
		List<Customer> listitems=Arrays.asList(new Customer("Karry",34),
				new Customer("Kappy",32),
						new Customer("Kenithy",32),
								new Customer("karishma",324)
										
				
				);
	
		List<String>methods=		listitems.stream().
				map(Customer::getName). //get all the getNmaes method of Customer class, each return type is String, so output will be List of strings
				collect(Collectors.toList());
				
			//System.out.println(methods);	
		methods.forEach(System.out::print);
				
	}

}
