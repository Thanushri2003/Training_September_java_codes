import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    // Read integer with range validation
    public static int readInt(String prompt, int min, int max) throws CustomException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException("Invalid input. Please enter a valid integer.");
        }
        if (value < min || value > max) {
            throw new CustomException("Input must be between " + min + " and " + max + ".");
        }
        return value;
    }

    // Read double with range validation
    public static double readDouble(String prompt, double min, double max) throws CustomException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new CustomException("Invalid input. Please enter a valid number.");
        }
        if (value <= min || value > max) {
            throw new CustomException("Input must be > " + min + " and ≤ " + max + ".");
        }
        return value;
    }

    // Read any string input
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Read a single char from allowed list (like 'Y', 'N')
    public static char readChar(String prompt, char[] allowed) throws CustomException {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.length() != 1) {
            throw new CustomException("Input must be a single character.");
        }
        char ch = input.charAt(0);
        for (char a : allowed) {
            if (Character.toUpperCase(ch) == Character.toUpperCase(a)) {
                return Character.toUpperCase(ch); // Normalize output to uppercase
            }
        }
        throw new CustomException("Invalid character input. Allowed: " + new String(allowed));
    }

    // Ask for confirmation (Y/N)
    public static boolean confirm(String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }

    // Press Enter to continue
    public static void readEnter(String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
    }
}
