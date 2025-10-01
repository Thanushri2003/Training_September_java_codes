
class Exp2 extends Thread {
	
	@Override
	 public void run() 
	    {
	        try 
	        {
	          Thread.sleep(1000);
	            System.out.println("Run()"+Thread.currentThread().getName());
	        } 
	        catch (Exception | InterruptedException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }

}


public class MultiThread {
	public static void main(String[] args)
	{
		Exp2 t1=new Exp2();
		
		Thread t2=new Thread(t1,"thanu1");
		Thread t3=new Thread(t1,"thanu2");
		Thread t4=new Thread(t1,"thanu3");
		Thread t5=new Thread(t1,"thanu4");
		
//		t2.setDaemon(true);
		t2.setPriority(Thread.MAX_PRIORITY);// max =10(execute first)
		t2.start();
		t3.start();
		t4.start();
		t5.start();


		System.out.println("Thread 2 Priority: "+t2.getPriority());
		System.out.println("Thread 5 Priority: "+t5.getPriority());
		
	}

}