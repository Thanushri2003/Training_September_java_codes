import java.util.Iterator;

class ArrayQueue<T> implements Iterable<T>
{
	private T[] aq;
	private int rear;
	private int front;
	private int capacity;
	private int currentsize; //current index
	
	public ArrayQueue(int cap)
	{
		this.capacity=cap;
		this.aq=(T[]) new Object[capacity];
		this.front=0;
		this.rear=-1;
		this.currentsize=0;
		
	}
	
	public void enqueue(T input)
	{
		if(isFull()) //cuurent size==capacity
		{
			System.out.println("Queue is full");
			return;
			
		}
		
		rear=(rear+1)%capacity;
		aq[rear]=input;
		currentsize++;
		System.out.println("ADDED ONE RECORD");
	}
	
	public T dequeue()
	{
		if(isEmpty())
		{
			System.out.println("NO RECORDS TO REMOVE");
			return null;
		}
		
		T ele=aq[front];
		aq[front]=null;
		front=(front+1)%capacity;
		currentsize--;
		System.out.println("REMOVED ONE ELE FROM FRONT");
		return ele;
		
	}
	
	public T peek()
	{
		if(isEmpty())
		{
			System.out.println("EMPTY QUEUE");
			return null;
		}
		
		T first=aq[front];
		return first;
	}
	
	public boolean isEmpty()
	{
		return currentsize==0;
	}
	
	public boolean isFull()
	{
		return currentsize==capacity;
		
	}
	
	public int size()
	{
		return currentsize;
	}

//	@Override
//	public Iterator<ArrayQueue<T>> iterator() {
//		// TODO Auto-generated method stub
//		ArrayQueue<T> data=new ArrayQueue<>(capacity);
//		Iterator<ArrayQueue<T>> itr=data.iterator();
//		return null;
//	}
//	
	@Override
	public Iterator<T> iterator() {
	    return new Iterator<T>() {
	        private int index = front;
	        private int count = 0;

	        @Override
	        public boolean hasNext() {
	            return count < currentsize;
	        }

	        @Override
	        public T next() {
	            T item = aq[index];
	            index = (index + 1) % capacity;
	            count++;
	            return item;
	        }
	    };
	}

}



public class ArrayQueue1 {
	public static void main(String[] args)
	{
		ArrayQueue<Integer> data=new ArrayQueue<>(5);
		
		data.enqueue(5);
		data.enqueue(10);
		data.enqueue(30);
		data.dequeue();
		System.out.println("Size: "+data.size());
		data.enqueue(100);
		System.out.println("Size: "+data.size());

		System.out.println("Peek: "+data.peek());
		data.enqueue(30);
		data.enqueue(80);
		data.enqueue(60);
		
		System.out.println("Queue contents:");
		for (Integer item : data) {
		    System.out.println(item);
		}
		
		
	}
	
}
