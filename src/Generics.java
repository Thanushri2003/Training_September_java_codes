
//T REPRESENTS ANY DATE TYPE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Order<T>
{
	private T item;
	
	public Order(T item)
	{
		this.item=item;
	}
	
	public T getItem()
	{
		return item;
	}
}

class Apple
{
	
}




class Cus extends Order<Apple>
{
	public Cus(Apple item)
	{
		super(item);
	}
	
}
public class Generics {
	public static void main(String[] args)
	{
		//bounded wildcard type
		List<? super Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		list.stream().forEach(System.out::println);
		//or
		System.out.println(list);
		
		
		//unbounded wildcard
		List<?> data=Arrays.asList(23,45,67,44);
		List<?> data1=Arrays.asList("java",23,45,67,44);

	}

}
