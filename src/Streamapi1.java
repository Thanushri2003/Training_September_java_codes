import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamapi1 {
	
	public static void main(String[] args)
	{
		List<String> data=Arrays.asList("rohit","rohit","kohli","rahul","dravid");
		
		for(String nm:data)
		{
			if(nm.startsWith("r"))
			{
				System.out.println(nm);
			}
		}
		
		//using stream api
		
		//sequentical operation 
		//predicate type
		data.stream()
		.filter(x->x.startsWith("r"))
		.forEach(System.out::println);
		
		//prints the distinct records
		//collect is the internal operator
		List<String> filterdata=data.stream().filter(x->x.startsWith("r"))
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(filterdata);
		
		System.out.println(data.stream().filter(x->x.startsWith("r")));
		
		
		Stream<String> strm=data.stream();
		List<Integer> num=Arrays.asList(2,3,4,5,6,7);
		List<Integer> sq=num.stream().filter(n->n%2 ==0)
				.map(x->x*x).toList();
	}

}
