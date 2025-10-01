import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadsCollection {
	public static void main(String[] args)throws InterruptedException
	{
		
	List<Integer> list=new ArrayList<>();//not threadsafe
	CopyOnWriteArrayList<Integer> data=new CopyOnWriteArrayList();//threadsafe
	
	Thread t1=new Thread(()->{
		for(int i=0;i<1000;i++)
		{
			list.add(i);
			data.add(i);
		}
	});
	
	Thread t2=new Thread(()->{
		for(int i=0;i<1000;i++)
		{
			list.add(i);
			data.add(i);
		}
	});

	t1.start();
	t2.start();
	
	t1.join();
	t2.join();
	
	System.out.println("Total size on Normal List: "+list.size());
	System.out.println("Total size on CopyOnWriteArrayList: "+data.size());

	}

}
