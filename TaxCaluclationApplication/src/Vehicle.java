public class Vehicle {
    private String registrationNumber;
    private String brand;
    private double purchaseCost;
    private int maxVelocity;
    private int capacity;
    private int type; // 1=Petrol, 2=Diesel, 3=CNG/LPG

    public Vehicle(String registrationNumber, String brand, double purchaseCost,
                   int maxVelocity, int capacity, int type) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.purchaseCost = purchaseCost;
        this.maxVelocity = maxVelocity;
        this.capacity = capacity;
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public int getMaxVelocity() {
        return maxVelocity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getType() {
        return type;
    }
    
    private boolean taxCalculated = false;

 
    public boolean isTaxCalculated() {
        return taxCalculated;
    }
    
    public void setTaxCalculated(boolean calculated) {
        this.taxCalculated = calculated;
    }


    public double getTaxAmount() {
        double baseRate = switch (type) {
            case 1 -> 0.10; // Petrol
            case 2 -> 0.12; // Diesel
            case 3 -> 0.08; // CNG/LPG
            default -> 0.0;
        };
        this.taxCalculated = true; 
        double speedFactor = (maxVelocity > 200) ? 1.10 : 1.00; // 10% more if speed > 200
        double capacityFactor = (capacity > 5) ? 1.05 : 1.00;   // 5% more if seats > 5

        return purchaseCost * baseRate * speedFactor * capacityFactor;
    }
}
