
public class DeadlockDemo {
    public static final Object obj1 = new Object();
    public static final Object obj2 = new Object();
 
    public static void main(String[] args){
       
        Thread t1 = new Thread(() -> {
            synchronized(obj1){
                System.out.println("Thread 1 locked - 1");
                try {
                    Thread.sleep(1000);
                } catch (Exception  |InterruptedException e) {
                    // TODO: handle exception
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                synchronized(obj2){
                    System.out.println("Thread 1 locked - 2");
                }
            }
        });
 
        Thread t2 = new Thread(() -> {
            synchronized(obj2){
                System.out.println("Thread 2 locked - 1");
                try {
                    Thread.sleep(1000);
                } catch (Exception |InterruptedException e) {
                    // TODO: handle exception
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                synchronized(obj1){
                    System.out.println("Thread 2 locked - 2");
                }
            }
        });
 
        t1.start();
        t2.start();
    }
   
}