import java.util.Map;

class Student
{
	public int id;
	public String name;
	public String college;
	public String city;
	
	public Student(int id,String n,String col,String ci)
	{
		this.id=id;
		this.name=n;
		this.college=col;
		this.city=ci;
	}
}

class CreateStudents
{
	void create(Map<Integer,Student> db,Student student)
	{
		db.put(student.id, student);
		System.out.println("Student is created");
		
	}
}

class ReadStudents
{
	void read(Map<Integer,Student> db, int id)
	{
		Student student = db.get(id);
        if (student != null) {
            System.out.println("Student record: " + student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
	}
}


class UpdateStudents
{
	void update(Map<Integer,Student> db,Student newstudent)
	{
		if(db.containsKey(newstudent.id))
		{
			db.put(newstudent.id,newstudent);
			System.out.println("student updated");
		}
		
		else
		{
			System.out.println("Student not found");
		}
	}
}




public class FacadeStudentRecords {

}
