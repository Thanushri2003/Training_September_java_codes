import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Predicate1 {
	
	public static void main(String[] args)
	{
		String str="java";
		
		Predicate<String> pr=str1 ->str.length()>4;
		Function<String,Integer> fn=s1->s1.length();
		Consumer<String> cn=s2->System.out.println(s2);
		
		Supplier<String> sp=()->"Hello";
		System.out.println(sp.get());
		
		BinaryOperator<Integer> bn=(a,b)->a+b;
		System.out.println(bn.apply(20,30));
		
		UnaryOperator<Integer> un=z->z*z;
		System.out.println(un.apply(5));
		
	}

}
