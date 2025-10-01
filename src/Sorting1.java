import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Emp1
{
	public int empid;
	public String name;
	public int sal;
	
	
	public Emp1(int empid, String name, int sal) {
	    this.empid = empid;
	    this.name = name;
	    this.sal = sal;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
}

public class Sorting1 {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("rohit", "kohil", "dravid", "axar", "Thanushri", "krithik");
        data.stream().sorted().forEach(System.out::println);
        
        System.out.println(data.stream().count());
        
        System.out.println(data.stream().findFirst());
        System.out.println(data.parallelStream().findFirst());
        
        System.out.println(data.stream().findAny());
        System.out.println(data.parallelStream().findAny());




        List<Emp1> emp1 = Arrays.asList(
            new Emp1(22, "Aash", 5378864),
            new Emp1(2, "Vishnu", 5358264),
            new Emp1(3, "Kapilesh", 86453864),
            new Emp1(4, "Pragatheesh", 53856464),
            new Emp1(5, "Dharunesh", 56543864),
            new Emp1(6, "Saruksh", 5386454)
        );

        emp1.stream()
            .sorted(Comparator.comparing(Emp1::getEmpid)
                .thenComparing(Emp1::getName)
                .thenComparing(Emp1::getSal))
            .forEach(e -> System.out.println(e.getEmpid() + " " + e.getName()));
        
        
        emp1.stream()
        .sorted(Comparator.comparing(Emp1::getSal)
            .thenComparing(Emp1::getName)
            .thenComparing(Emp1::getSal))
        .forEach(e -> System.out.println(e.getEmpid() + " " + e.getName()));
        
        
    }
}

