package Designer;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimenumberwithParallelStream {

	public static void main(String[] args) {
		
		isPrime(14);
		
		//long count=Stream.iterate(0,n-> n+1).limit(1000).filter(PrimenumberwithParallelStream::isPrime).peek(System.out::println).count();
		//System.out.println("Count is "+count);
		
		
		//long pcount=Stream.iterate(0,n-> n+1).limit(1000).parallel().filter(PrimenumberwithParallelStream::isPrime).peek(System.out::println).count();
		//System.out.println("Count is "+pcount);
		
	}
	
	
	public static boolean isPrime(int num)
	{
		if(num<=1)
		{
			return false;
		}
		else
		{
			boolean b= 	IntStream.rangeClosed(2, num/2).anyMatch(x-> num%x == 0);
			System.out.println(b);
			return b;
		}
		
		
	}

}
