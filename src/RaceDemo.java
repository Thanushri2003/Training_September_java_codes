
public class RaceDemo {
	private static int count=0;
	
	public static void main(String[] args)throws InterruptedException
	{
		Thread t1 = new Thread(() -> {
		    System.out.println("run() thread 1 " + count);
		    for (int i = 0; i < 1000000; i++) {
		        count++;
		    }
		});
		
		
		Thread t2=new Thread(()->
		{
			System.out.println("run() thread 2 "+count);
			for(int i=0;i<1000000;i++)
			{
				count++;
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("The final count value: "+count);//becuase of race condition the value may differ
		
	}

}
