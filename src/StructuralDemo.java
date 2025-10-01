interface Target
{
	public void request();
}

class Adaptee
{
	public void specificRequest()
	{
		System.out.println("Simple request");
	}
}

class Adapter implements Target
{
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee)
	{
		this.adaptee=adaptee;
	}
	
	@Override
	public void request() {
		adaptee.specificRequest();
	}
}

public class StructuralDemo {
	public static void main(String args[])
	{
		Adaptee o1=new Adaptee();
		Adapter o2=new Adapter(o1);
		
		o2.request();
	}

}

