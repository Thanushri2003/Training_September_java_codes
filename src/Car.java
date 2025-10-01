public class Car {

    // Nested interface inside Car
    public interface Engine {
        void start();
        void stop();
    }

    // Class implementing the nested interface
    static class PetrolEngine implements Engine {
        @Override
        public void start() {
            System.out.println("Petrol Engine Started");
        }

        @Override
        public void stop() {
            System.out.println("Petrol Engine Stopped");
        }
    }

    public void runCar() {
        Engine engine = new PetrolEngine();
        engine.start();
        System.out.println("Car is running...");
        engine.stop();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.runCar();
    }
}


























































//import java.io.Serializable;
//import java.rmi.Remote;
//
//// Outer interface with nested interface
//interface Inf11 {
//    void add(); // Not used in this example
//
//    interface Inf2 {
//        void mul();
//    }
//}
//
//// Class implementing the nested interface
//class Impl1 implements Inf11.Inf2 {
//    public void mul() {
//        System.out.println("Multiplication method from nested interface.");
//    }
//}
//
//// Class implementing Cloneable, Serializable, and Remote
//class Impl2 implements Cloneable, Serializable, Remote {
//    int id;
//    String name;
//
//    Impl2(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Impl2 clone() {
//        try {
//            return (Impl2) super.clone();
//        } catch (CloneNotSupportedException e) {
//            System.out.println("Cloning failed.");
//            return null;
//        }
//    }
//
//    public void display() {
//        System.out.println("ID: " + id + ", Name: " + name);
//    }
//}
//
//// Main class
//public class NestedInterface {
//    public static void main(String[] args) {
//        // Using Impl1
//        Impl1 obj1 = new Impl1();
//        obj1.mul();
//
//        // Using Impl2
//        Impl2 original = new Impl2(101, "Thanu");
//        Impl2 cloned = original.clone();
//
//        System.out.println("\nOriginal Object:");
//        original.display();
//
//        System.out.println("Cloned Object:");
//        cloned.display();
//    }
//}