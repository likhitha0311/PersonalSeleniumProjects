package Designer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfiniteStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	List<Integer>c=IntStream.iterate(0, n->n+2).mapToObj(Integer::valueOf).limit(100).collect(Collectors.toList());
	System.out.println(c);
		
	}

}
