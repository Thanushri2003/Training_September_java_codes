@FunctionalInterface
interface FunInf {
    String greetUser(String msg);
}

public class FunctionalInterface1 {
    public static void main(String[] args) {
        FunInf o = (String msg) -> {
            String text = "Hi hello MLA Developers";
            System.out.println(text);
            return msg + " " + text;
        };

        System.out.println(o.greetUser("THANU"));
    }
}
