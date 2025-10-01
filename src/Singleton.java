 

public class Singleton { 

    // Step 1: Create a private static instance of the class 

    private static Singleton instance; 

    // Step 2: Make the constructor private so no other class can instantiate it 

    private Singleton() { 

        System.out.println("Singleton instance created."); 

    } 

    // Step 3: Provide a public static method to get the instance 

    public static Singleton getInstance() { 
    	synchronized(instance) {

        if (instance == null) { 

            instance = new Singleton(); 

        } }

        return instance; 

    } 

    // Example method 

    public void showMessage() { 

        System.out.println("Hello from Singleton!"); 

    } 

    // Main method to test 

    public static void main(String[] args) { 

        Singleton obj1 = Singleton.getInstance(); 

        obj1.showMessage(); 

        Singleton obj2 = Singleton.getInstance(); 

        obj2.showMessage(); 

        // Check if both references point to the same object 

        System.out.println("Are both instances same? " + (obj1 == obj2)); 

    } 

} 
