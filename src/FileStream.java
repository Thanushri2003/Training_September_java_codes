

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.stream.Stream;

class StudentStream implements Serializable
{
	private static final long serialVersionUID = 1L;

	public int id;
	
	public String name;
	
	public transient String city;

	public StudentStream(int id, String name, String city) {
		
		this.id = id;
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}

public class FileStream {
	
	public static void main(String[] args) throws IOException {
		
		String path = "src/student.txt";
		
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream objout = new ObjectOutputStream(fos);
			
			objout.writeObject(new StudentStream(1, "Rohit", "Mumbai"));
			
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream objinput = new ObjectInputStream(fis);
			
			Stream<StudentStream> strm = Stream.generate(() -> {
				try
				{
					return (StudentStream) objinput.readObject();
				}
				catch(IOException | ClassNotFoundException e)
				{
					return null;
				}
			}).takeWhile(obj -> obj != null);
			
			strm.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

