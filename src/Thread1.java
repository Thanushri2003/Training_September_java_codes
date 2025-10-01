class Exp1 extends Thread {
	
    public void run() 
    {
        try 
        {
            Thread.sleep(1000);
            System.out.println("Run()");
        } 
        catch (Exception | InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

public class Thread1 {
	
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Exp1();
        
        System.out.println("The state of the program: " + t1.getState());
        System.out.println("The status of the program: " + t1.isAlive());

        t1.start();

        System.out.println("The state of the program: " + t1.getState());
        System.out.println("The status of the program: " + t1.isAlive());

        Thread.sleep(1000); //or can use t1.sleep();
        
        System.out.println("The state of the program: " + t1.getState());
        System.out.println("The status of the program: " + t1.isAlive());

        t1.join();
        
        System.out.println("The state of the program: " + t1.getState());
        System.out.println("The status of the program: " + t1.isAlive());
    }
}