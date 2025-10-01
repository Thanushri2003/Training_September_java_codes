import java.util.Stack;

public class Stack1 {
	public static void main(String[] args)
	{
		Stack data=new Stack();
		
		data.add("java");
		data.add(300);
		data.add(300);
		data.add("c");
		data.add("Text");
		data.add("java");
		
		System.out.println(data.peek());
		System.out.println(data.pop());
		
		data.push("spring");
		System.out.println(data);
		data.clear();
		System.out.println(data.isEmpty());
		System.out.println(data.search("mla"));
			
	}

}
