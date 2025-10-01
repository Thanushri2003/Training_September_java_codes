import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args)
	{
		int[] arr= {60,'a',80,30,'b','z',50,'j',5};
		Arrays.sort(arr);
//		
//		for(char x:arr)
//		{
//			System.out.println(x);
//		}
		
		String str=Arrays.toString(arr);
		System.out.println(str);
		
		String input="23541fhfgh842";
		char[] ch=input.toCharArray();
		Arrays.sort(ch);
		
		StringBuilder chs=new StringBuilder();
		StringBuilder nums=new StringBuilder();
		
		
		for(char j:ch)
		{
			if(Character.isLetter(j))
			{
				chs.append(j);
			}
			else if(Character.isDigit(j))
			{
				nums.append(j);
			}
			
		}
		System.out.println(chs+" "+nums);
	}

}
