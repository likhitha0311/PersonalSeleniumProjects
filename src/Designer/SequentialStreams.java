package Designer;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequentialStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s=Stream.of("a","b","c","d").filter(x->x.equals("a")).findAny().get();
		System.out.println(s);
		
		//1.
		Stream stream=Stream.of("Pinky","Partha","Mike","Allow");
		
		stream.forEach(System.out::println);
		
		
		
		//stream.count();//This statement is invalid because stream has already been operated upon or closed
		
		//2.
		
		Arrays.asList("a","b","c","d").stream().findFirst().ifPresent(System.out::println);
		
		//3.
		
		IntStream.range(1, 6).forEach(System.out::println);
		
		//4.
		Arrays.stream(new int [] {1,2,3,4,5}).map(n->2*n).average().ifPresent(System.out::println);;
		
		//5.
		
		Stream.of("a1","b2","c3","d4").map(s1->s1.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
		
		//6.
		//Stream.of(1.9,2.3,4.5,6.7).mapToInt(Double :: intvalue).mapToObj(i->"a1"+i).forEach(System.out::println);
		
		Stream.iterate(0,n->n+1).limit(10).forEach(System.out::println);
		
		//7
		
		Stream.iterate(0,n->n+1).filter(x->x%2 !=0).limit(10).forEach(System.out::println);
		
	}

}
