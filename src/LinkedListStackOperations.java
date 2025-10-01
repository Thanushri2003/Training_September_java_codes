
import java.util.LinkedList;

class CustomStack1<T> {
    private LinkedList<T> stackList;
    private int cap;

    public CustomStack1(int capacity) {
        this.cap = capacity;
        this.stackList = new LinkedList<>();
    }

    public void push(T input) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stackList.addLast(input); // Add to the end (top of stack)
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackList.removeLast(); // Remove from the end
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stackList.getLast(); // Peek at the end
    }

    public int size() {
        return stackList.size();
    }

    public boolean isFull() {
        return stackList.size() == cap;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }
}
public class LinkedListStackOperations {

	   public static void main(String[] args) {
	        CustomStack1<Integer> obj1 = new CustomStack1<>(7);
	        obj1.push(20);
	        obj1.push(30);
	        obj1.push(50);
	        obj1.push(80);
	        obj1.push(90);

	        System.out.println("From stack: " + obj1.peek());
	        obj1.pop();
	        System.out.println("From stack: " + obj1.peek());
	        System.out.println("Size of stack: " + obj1.size());
	        System.out.println("Empty? " + obj1.isEmpty());
	    
	   }
}
