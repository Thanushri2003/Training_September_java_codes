

class CustomStack<T>
{
	private T[] inputarr;
	private int top;
	private int cap;
	
	public CustomStack(int capacity)
	{
		this.cap=capacity;
		this.inputarr=(T[])new Object[capacity];//type casting obj to arr
		this.top=-1;//initial
	}
	
	public void push(T input)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
			return;
		}
		top++;
		inputarr[top]=input;
		
	}
	
	public T pop()
	{
		if(isEmpty())
		{
			System.out.println("stack is empty");
			return null;
		}
		T poprc=inputarr[top];
		inputarr[top]=null;
		
		top--;
		return poprc;
	}
	
	public T peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return null;
		}
		return inputarr[top];
	}
	
	public int size()
	{
		return top+1;
	}
	
	public boolean isFull()
	{
		return top==cap-1;
	}
	
	public boolean isEmpty()
	{
		return top==-1;
	}
}


public class Stack2 {
	
public static void main(String[] args)
{
	CustomStack<Integer> obj1=new CustomStack(7);
	obj1.push(20);
	obj1.push(30);
	obj1.push(50);
	obj1.push(80);
	obj1.push(90);
	System.out.println("From stack "+obj1.peek());
	obj1.pop();
	System.out.println("From stack "+obj1.peek());
	System.out.println("size stack "+obj1.size());
	System.out.println("Empty? "+obj1.isEmpty());

	

}
}
