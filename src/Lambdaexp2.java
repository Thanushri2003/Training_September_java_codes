interface FunInf2
{
	String sayHello(String name);
}

public class Lambdaexp2 {
	public static void main(String[] args)
	{
		FunInf2 o=(String name) ->
		{
			System.out.println("hi "+name);
			return "This is simple lambda exp";
		};
		
		System.out.println(o.sayHello("sky"));
	}
}


//System.out.println --->excepts all data type except void
//System.out.print-->cant keep empty but should provide smtg inside the paranthesis