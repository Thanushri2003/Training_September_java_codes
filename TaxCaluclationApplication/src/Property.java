public class Property {
    private double builtUpArea;
    private double baseValue;
    private int age;
    private boolean inCity;

    public Property(double builtUpArea, double baseValue, int age, boolean inCity) {
        this.builtUpArea = builtUpArea;
        this.baseValue = baseValue;
        this.age = age;
        this.inCity = inCity;
    }

    public double getBuiltUpArea() {
        return builtUpArea;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public int getAge() {
        return age;
    }

    public boolean isInCity() {
        return inCity;
    }

    
    private boolean taxCalculated = false;

 
    public boolean isTaxCalculated() {
        return taxCalculated;
    }
    
    public void setTaxCalculated(boolean calculated) {
        this.taxCalculated = calculated;
    }

    public double getTaxAmount() {
        double areaRate = inCity ? 15 : 10; // ₹15/sqft in city, ₹10/sqft otherwise
        double ageDiscount = (age > 20) ? 0.2 : 0; // 20% discount if age > 20 years

        double totalValue = builtUpArea * areaRate + baseValue;
        double tax = totalValue * 0.05; // 5% property tax
        this.taxCalculated = true; 

        return tax * (1 - ageDiscount);
    }
}
