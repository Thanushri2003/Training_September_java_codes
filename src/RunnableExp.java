
public class RunnableExp {
	public static void main(String[] args)
	{
		Runnable t1=()->
		{
			System.out.println("run()"+Thread.currentThread());
		};//with lambda
		
		Thread t2=new Thread(t1);
		t2.start();
		
		Thread t3=new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("run()"+Thread.currentThread());

			}
			
	    });
	    
		t3.start();
		
		
	}
}
