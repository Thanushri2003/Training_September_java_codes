public interface Vehicle {
    void color();
    void brand();
}

public abstract class JavaCar implements Vehicle {
//    @Override
//    public void color() {
//        System.out.println("JavaCar is Red");
//    }
//
//    // brand() left abstract for subclasses
//    public abstract void brand();
	
    public void show()
    {
    	System.out.println("Java car");
    }
}

public abstract class KotlinCar implements Vehicle {
//    @Override
//    public void color() {
//        System.out.println("KotlinCar is Blue");
//    }
//
//    @Override
//    public void brand() {
//        System.out.println("Brand: Kotlin Motors");
//    }
	
	public void display()
	{
		System.out.println("Kotlin car");
	}
}

class VehicleImpl implements Vehicle
{
    @Override
    public void color() {
        
    }

    @Override
    public void brand() {
        
    }
}


public class Honda extends JavaCar {
    @Override
    public void brand() {
        System.out.println("Brand: Honda");
    }
}

public class FactoryDemo {
	

	 public static void main(String[] args) {
	        Vehicle v1 =new Honda();
	        v1.color();
	        v1.brand();
//	        v1.show();

	        Vehicle v2 = new VehicleImpl();
	        v2.color();
	        v2.brand();
	    }

	

}
