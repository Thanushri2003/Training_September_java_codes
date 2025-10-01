interface FunInf1
{
	void greet();
}

public class Lambdaexp {
	public static void main(String args[])
	{
		//functional interface
		FunInf1 o=new FunInf1()
				{
			@Override
			public void greet()
			{
				System.out.println("functional interface");			}
			};
			o.greet();
			
			//nameless object
			new FunInf1()
			{
				@Override
				public void greet()
				{
					System.out.println("nameless obj");			}
			}.greet();
			
			//lambda experssion
			FunInf1 o2=()->
			{
				System.out.println("lambda exp");
			};
			o2.greet();
				
	}
				
}


