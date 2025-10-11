import java.util.ArrayList;
import java.util.List;

public class TaxCalMain {
    private static List<Property> properties = new ArrayList<>();
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static String username = "";

    public static void main(String[] args) {
    	
    	
    	if (!login()) {
            System.out.println("Too many failed attempts. Exiting...");
            System.exit(1);
        }

        printWelcomeScreen();

        while (true) {
            try {
                int choice = Utils.readInt("\nMain Menu:\n1. Property Tax\n2. Vehicle Tax\n3. Total Tax Summary\n4. Exit\nEnter your choice: ", 1, 4);

                switch (choice) {
                    case 1:
                        propertyTaxMenu();
                        break;
                    case 2:
                        vehicleTaxMenu();
                        break;
                    case 3:
                        displaySummary();
                        break;
                    case 4:
                        System.out.println("\nThank you for using Tax Calculator!");
                        System.exit(0);
                        break;
                }
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    
    private static boolean login() {
        System.out.println("=======================================");
        System.out.println("       TAX CALCULATOR LOGIN");
        System.out.println("=======================================");

        int attempts = 3;
        while (attempts > 0) {
            String inputUser = Utils.readString("Enter Username: ");
            String inputPass = Utils.readString("Enter Password: ");

            if (inputUser.equals("admin") && inputPass.equals("admin123")) {
                username = inputUser; 
                System.out.println("Login successful!\n");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts left: " + attempts);
            }
        }

        return false; // after 3 failed attempts
    }


    private static void printWelcomeScreen() {
        System.out.println("=======================================");
        System.out.println("           TAX CALCULATOR");
        System.out.println("       Developed by:"+username);
        System.out.println("=======================================");
        System.out.println("Welcome! Please select an option from the menu.");
    }

    // ----------- Property Tax Menu -----------------
    private static void propertyTaxMenu() {
        while (true) {
            try {
                int choice = Utils.readInt(
                        "\nProperty Tax Menu:\n" +
                        "1. Add Property Details\n" +
                        "2. Calculate Property Tax\n" +
                        "3. Display All Properties\n" +
                        "4. Back to Main Menu\n" +
                        "Enter your choice: ", 1, 4);

                switch (choice) {
                    case 1:
                        addProperty();
                        break;
                    case 2:
                        calculatePropertyTax();
                        
                        break;
                    case 3:
                        displayAllProperties();
                        break;
                    case 4:
                        return; // back to main menu
                }
            } catch (CustomException e) {
                System.out.println("Input Error: " + e.getMessage());
            }
        }
    }

    private static void addProperty() {
        try {
            System.out.println("\n--- Add Property Details ---");

            double builtUpArea = Utils.readDouble("Enter built-up area (sq.ft, > 0): ", 0, Double.MAX_VALUE);
            double baseValue = Utils.readDouble("Enter base value of land (INR, > 0): ", 0, Double.MAX_VALUE);
            char cityChar = Utils.readChar("Is the property located in main city? (Y/N): ", new char[] { 'Y', 'N' });
            boolean inCity = Character.toUpperCase(cityChar) == 'Y';
            int age = Utils.readInt("Enter age of construction (years, > 0): ", 1, Integer.MAX_VALUE);

            Property property = new Property(builtUpArea, baseValue, age, inCity);
            // Note: tax is calculated inside Property constructor or getTaxAmount method

            if (Utils.confirm("Do you want to save this property data?")) {
                properties.add(property);
                System.out.println("Property details saved.");
            } else {
                System.out.println("Property details discarded.");
            }
        } catch (CustomException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    private static void calculatePropertyTax() {
        if (properties.isEmpty()) {
            System.out.println("No properties available to calculate tax.");
            return;
        }
        displayPropertiesTable(false);// false means show tax amount as 0 initially
        try {
            int id = Utils.readInt("Enter Property ID to calculate tax: ", 1, properties.size());
            Property p = properties.get(id - 1);
            double tax = p.getTaxAmount();
            p.setTaxCalculated(true);
            System.out.printf("Property ID %d: Calculated Property Tax = ₹%.2f\n", id, tax);
        } catch (CustomException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    private static void displayAllProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties to display.");
            return;
        }
        displayPropertiesTable(true); // true means show actual tax amounts
    }

    private static void displayPropertiesTable(boolean showTax) {
        System.out.println("+----+-------------+------------+-----+---------+----------------+");
        System.out.println("| ID | Built-Up    | Base Value | Age | In City | Property Tax   |");
        System.out.println("+----+-------------+------------+-----+---------+----------------+");
        

        for (int i = 0; i < properties.size(); i++) {
            Property p = properties.get(i);
            String inCityStr = p.isInCity() ? "Yes" : "No";
            double tax = (showTax && p.isTaxCalculated()) ? p.getTaxAmount() : 0.0;
            System.out.printf("| %2d | %11.2f | %10.2f | %3d | %7s | ₹%12.2f |\n",
                    i + 1, p.getBuiltUpArea(), p.getBaseValue(), p.getAge(), inCityStr, tax);
        }
        System.out.println("+----+-------------+------------+-----+---------+----------------+");
    }

    // ----------- Vehicle Tax Menu -----------------
    private static void vehicleTaxMenu() {
        while (true) {
            try {
                int choice = Utils.readInt(
                        "\nVehicle Tax Menu:\n" +
                        "1. Add Vehicle Details\n" +
                        "2. Calculate Vehicle Tax\n" +
                        "3. Display All Vehicles\n" +
                        "4. Back to Main Menu\n" +
                        "Enter your choice: ", 1, 4);

                switch (choice) {
                    case 1:
                        addVehicle();
                        break;
                    case 2:
                        calculateVehicleTax();
                        break;
                    case 3:
                        displayAllVehicles();
                        break;
                    case 4:
                        return; // back to main menu
                }
            } catch (CustomException e) {
                System.out.println("Input Error: " + e.getMessage());
            }
        }
    }

    private static void addVehicle() {
        try {
            System.out.println("\n--- Add Vehicle Details ---");

            String regNumber = Utils.readString("Enter 4-digit registration number (not 0000): ");
            if (!regNumber.matches("\\d{4}") || regNumber.equals("0000")) {
                throw new CustomException("Registration number must be 4 digits and not 0000.");
            }

            String brand = Utils.readString("Enter vehicle brand: ");
            if (brand.isEmpty()) {
                throw new CustomException("Brand cannot be empty.");
            }

            double purchaseCost = Utils.readDouble("Enter purchase cost (INR 50000 to 1000000): ", 50000, 1000000);
            int maxVelocity = Utils.readInt("Enter max velocity (120 to 300 km/h): ", 120, 300);
            int capacity = Utils.readInt("Enter seating capacity (2 to 50): ", 2, 50);
            int type = Utils.readInt("Enter vehicle type (1: Petrol, 2: Diesel, 3: CNG/LPG): ", 1, 3);

            Vehicle vehicle = new Vehicle(regNumber, brand, purchaseCost, maxVelocity, capacity, type);

            if (Utils.confirm("Do you want to save this vehicle data?")) {
                vehicles.add(vehicle);
                System.out.println("Vehicle details saved.");
            } else {
                System.out.println("Vehicle details discarded.");
            }
        } catch (CustomException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    private static void calculateVehicleTax() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available to calculate tax.");
            return;
        }
        displayVehiclesTable(false); // show tax as 0 initially
        try {
            int id = Utils.readInt("Enter Vehicle ID to calculate tax: ", 1, vehicles.size());
            Vehicle v = vehicles.get(id - 1);
            String reg=v.getRegistrationNumber();
            double tax = v.getTaxAmount();
            v.setTaxCalculated(true);

            System.out.printf("Vehicle RegNo %s: Calculated Vehicle Tax = ₹%.2f\n", reg, tax);
        } catch (CustomException e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    private static void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
            return;
        }
        displayVehiclesTable(true); // show actual tax
    }

    private static void displayVehiclesTable(boolean showTax) {
        String runBy;
        System.out.println("+----+------------+---------+--------------+-------------+----------+---------+--------------+");
        System.out.println("| ID | Reg Number | Brand   | Purchase Cost| Vehicle Type| Velocity | Seats   | Vehicle Tax  |");
        System.out.println("+----+------------+---------+--------------+-------------+----------+---------+--------------+");
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);

            if (v.getType() == 1) {
                runBy = "Petrol  ";
            } else if (v.getType() == 2) {
                runBy = "Diesel  ";
            } else {
                runBy = "CNG/LPG ";
            }

            double tax = (showTax && v.isTaxCalculated()) ? v.getTaxAmount() : 0.0;
            System.out.printf("| %2d | %10s | %7s | ₹%12.2f | %11s | %8d | %7d | ₹%12.2f |\n",
                    i + 1, v.getRegistrationNumber(), v.getBrand(), v.getPurchaseCost(), runBy,
                    v.getMaxVelocity(), v.getCapacity(), tax);
        }
        System.out.println("+----+------------+---------+--------------+-------------+----------+---------+--------------+");
    }


    // ----------- Total Summary ---------------
    private static void displaySummary() {
        System.out.println("\n--- Total Tax Summary ---");

        if (properties.isEmpty() && vehicles.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
            return;
        }

        double totalPropertyTax = properties.stream().mapToDouble(Property::getTaxAmount).sum();
        double totalVehicleTax = vehicles.stream().mapToDouble(Vehicle::getTaxAmount).sum();
        double grandTotal = totalPropertyTax + totalVehicleTax;
        
        System.out.println("+----+----------------+--------+-----------------------+");
        System.out.println("|SR.N| PARTICULAR     | Count  | Total Tax Payable     |");
        System.out.println("+----+----------------+--------+-----------------------+");
        System.out.printf("| %2d | %-14s | %6d | ₹%19.2f |\n", 1, "Property", properties.size(), totalPropertyTax);
        System.out.printf("| %2d | %-14s | %6d | ₹%19.2f |\n", 2, "Vehicle", vehicles.size(), totalVehicleTax);
        System.out.println("+----+----------------+--------+---------------------+");
        System.out.printf("|    | %-14s |        | ₹%19.2f |\n", "TOTAL", grandTotal);
        System.out.println("+----+----------------+--------+---------------------+");


        System.out.println("\nPress Enter to return to main menu...");
        Utils.readString("");
    }
}
