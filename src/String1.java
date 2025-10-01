
public class String1 {
	
	public static void main(String args[])
	{
		String s1="java";
		String s2="java";
		String s3="hello";
		
		String s4=new String("java");
		String s5=new String("test");
		
		System.out.println(s1==s2);
		System.out.println(s2.equals(s5));
		System.out.println(s1.concat("sri"));
		
		s1.concat(" 21");
		
		String str="Thanushri";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			System.out.print(str.charAt(i));
		}
		
	}

}
