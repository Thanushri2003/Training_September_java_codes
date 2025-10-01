import java.util.Scanner;

public class linearSearch {
	
	public static int linearsearch(int[] arr,int target)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(target==arr[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int arr[]= {2,45,7,8,96,3,4,5,1,2,7,8,54,5};
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		System.out.println("Element in: "+linearsearch(arr,s));
	}
}
