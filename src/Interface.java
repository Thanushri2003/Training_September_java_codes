interface Inf1
{
	void dog();
	private void testdata()
	{
		System.out.println("HII");
	}
	
	default void disp()
	{
		testdata();
	}
	
}
public class Interface implements Inf1 {
	@Override
	public void dog()
	{
		
	}
	
	public static void main(String[] arg)
	{
	Inf1 obj1=new Interface();
	obj1.disp();
	}
}
