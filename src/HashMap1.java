import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> scores = new HashMap<>();

        // Add key-value pairs
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 92);

        // Get the entrySet from the HashMap
        // entrySet() returns a set of key-value pairs (Map.Entry)
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();

        // Iterate using the Iterator
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }
    }
}
