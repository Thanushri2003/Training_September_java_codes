import java.util.Timer;
import java.util.TimerTask;

class TimerTest extends TimerTask
{
	private String taskName;
	
	public TimerTest(String taskName)
	{
		this.taskName=taskName;

	}
	@Override
	public void run()
	{
		System.out.println(taskName+" task from timer");
	}
}
public class TimerExp {
	public static void main(String[] args)throws InterruptedException
	{
		Timer timer=new Timer();
		timer.schedule(new TimerTest("Credit"), 2000);
		timer.scheduleAtFixedRate(new TimerTest("Transfer"),1000,3000);
		
		try
		{
			Thread.sleep(11000);
		}
		catch(Exception e)
		{
			Thread.currentThread().interrupt();
		}
		timer.cancel();
		System.out.println("Timer cancelled.");
	}
}
