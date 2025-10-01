public class SelectionSort {
	
	public static void sort(int arr[])
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++)
		{
			int minIndex=i;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[minIndex])
				{
					minIndex=j;
				}
			}
			
			//swap
			int temp=arr[minIndex];
			arr[minIndex]=arr[i];
			arr[i]=temp;
		}
		//outer loop
	}
	
	public static void main(String[] args)
	{
		int[] arr= {60,40,20,80,10,30};
		System.out.println("Unsorted array");
		
		for(int x:arr)
		{
			System.out.print(" "+x);
		}
		System.out.println("\nAfter sorting");
		sort(arr);
		
		for(int x:arr)
		{
			System.out.print(" "+x);
		}
		
	}

}
