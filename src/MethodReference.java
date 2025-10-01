import java.util.Arrays;
import java.util.List;

class Emp
{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Emp()
	{
		
	}
	//para constructor
	public Emp(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	
}
public class MethodReference {

		public static void main(String[] args)
		{
			//primitive so cant be called using method ref
//			int[] arr= {10,20,30,40,50};
			
			//used collection generic Integer
//			List<Integer>data=Arrays.asList(10,20,30,40,50);
			
			//stream api to achieve concrete functions
			
			//each is for enhanched for loop
//			data.stream().forEach(System.out::println);
			
//			for(int x :data)
//			{
//				System.out.println(x);
//			}
			
		Emp e=new Emp(1,"Thanu");
		Emp e1=new Emp(2,"shri");
		
		System.out.println(e.getId()+" "+e.getName());
		
		
		//generic Emp
		List<Emp> emplist=Arrays.asList(e,e1);
		emplist.forEach(data->System.out.println(data));
		emplist.stream().map(x->x.getName()).forEach(System.out::println);
		
		}
}
