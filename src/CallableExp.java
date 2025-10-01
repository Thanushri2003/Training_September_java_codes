import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableTest implements Callable<Integer>
{
	private final int num;
	public CallableTest(int num)
	{
		this.num=num;
	}

	@Override
	public Integer call() throws java.lang.Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		return num*num;
	}
	
}
public class CallableExp {
	
	public static void main(String[] args)throws  InterruptedException,ExecutionException
	{
		ExecutorService executor=Executors.newFixedThreadPool(3);
		CallableTest t1=new CallableTest(5);
		CallableTest t2=new CallableTest(4);
		CallableTest t3=new CallableTest(6);
		
		Future<Integer> f1=executor.submit(t1);
		Future<Integer> f2=executor.submit(t2);
		Future<Integer> f3=executor.submit(t3);
		
		System.out.println("Task one: "+f1.get());
		System.out.println("Task two: "+f2.get());
		System.out.println("Task three: "+f3.get());

		executor.shutdown();
	


	}

}
