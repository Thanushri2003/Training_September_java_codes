public class GetterAndSetter {
    private int id;
    private String name;
    private String clg;

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClg(String clg) {
        this.clg = clg;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClg() {
        return clg;
    }

    public static void main(String[] args) {
        GetterAndSetter gs = new GetterAndSetter();

        gs.setId(1);
        gs.setName("Thanu");
        gs.setClg("SASTRA");

        // Displaying the values
        System.out.println("ID: " + gs.getId());
        System.out.println("Name: " + gs.getName());
        System.out.println("College: " + gs.getClg());
        
        
    }
}