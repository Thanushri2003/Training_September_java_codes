import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

class Stu implements Comparable<Stu>
{
	private int id;
	private String name;
	private int age;
	
	

	public Stu(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name);
	}
	
	@Override
	public int compareTo(Stu o)
	{
		return o.id-this.id;
		
	}
	
	
}

class NameComparator implements Comparator<Stu>
{
	@Override
	public int compare(Stu o1,Stu o2)
	{
		return o1.getName().compareTo(o2.getName());
	}
	
}


public class Hashset2 {
	
	public static void main(String[] args)
	{
		TreeSet<Stu> data=new TreeSet<>();
		
		data.add(new Stu(1,"rohit",22));
		data.add(new Stu(2,"sky",32));
		data.add(new Stu(3,"virat",52));
		data.add(new Stu(4,"kane",42));
		
		Iterator<Stu> i=data.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
	}

}
