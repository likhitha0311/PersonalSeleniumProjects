package Designer;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsFlatmap {

	public static void main(String[] args) {

		int data[]= {1,2,3,4};
		
	     Stream<int[]> streamarray= Stream.of(data);//Youcannot apply map or filters to streamarray
	     
	     IntStream ints=streamarray.flatMapToInt(x->Arrays.stream(x));//flatmaptointeger returns intstream
	     
	     ints.forEach(System.out::println);
	}
	
}
