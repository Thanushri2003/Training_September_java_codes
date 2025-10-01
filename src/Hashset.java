import java.util.HashSet;
import java.util.Objects;

class Employee
{
	private int id;
	private String name;
	
	public Employee()
	{
		
	}
	
	public Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
}

public class Hashset {
	
	public static void main(String[] args)
	{
		HashSet<Employee> data=new HashSet<>();
		data.add(new Employee(1,"rohit"));
		data.add(new Employee(1,"rohit"));
		
		System.out.println(data.size());
		System.out.println(data);
	}
}
