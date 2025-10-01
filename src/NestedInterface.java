
// Outer interface
interface Vehicle {
    void drive();

    // Nested interface
    interface Engine {
        void start();
        void stop();
    }
}

// Class implementing outer interface
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Car is driving");
    }
}

// Class implementing nested interface
class PetrolEngine implements Vehicle.Engine {
    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }

    @Override
    public void stop() {
        System.out.println("Petrol Engine Stopped");
    }
}

// Demo class
public class NestedInterface {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.drive();

        Vehicle.Engine engine = new PetrolEngine();
        engine.start();
        engine.stop();
        
    }
}