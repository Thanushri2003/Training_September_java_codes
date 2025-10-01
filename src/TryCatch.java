import java.util.Scanner;

public class TryCatch {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			String str=sc.next();
			System.out.println("java");
			System.out.println(10/0);
		}
		catch(Exception e)
		{
			System.out.println("from catch");
			
			//using getMessage
			System.out.println(e.getMessage());
			
			//printing exception class object
			System.out.println(e);
			
			//using printStactTrace()
			e.printStackTrace();
		}
		finally
		{
			System.out.println("from finally");
			
		}
	}
}
