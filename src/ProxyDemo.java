interface UserData
{
	void userInfo();
}

class UserImpl implements UserData
{
	private String userName;
	public UserImpl(String userName)
	{
		this.userName=userName;
	}
	
	@Override
	public void userInfo()
	{
		System.out.println("The usr details:"+userName);
	}
	
	public void loadFromDB()
	{
		System.out.println("from databases");
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException  e)
		{
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
}

class UserProxy implements UserData
{
	private String userName;
	private UserImpl userObj;
	public UserProxy(String userName)
	{
		this.userName=userName;
	}
	
	@Override
	public void userInfo()
	{
		if(userObj==null)
		{
			userObj=new UserImpl(userName);
			
		}
		  userObj.userInfo();
	}
}

public class ProxyDemo {
	
	public static void main(String args[])
	{
		UserData obj1=new UserProxy("Rohit");
		UserData obj2=new UserProxy("sky");
		
		obj1.userInfo();
		obj1.userInfo();
		
		obj2.userInfo();

		
	}

}
