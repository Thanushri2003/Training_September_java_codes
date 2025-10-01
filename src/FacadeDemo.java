import java.util.*;

class Student {
    int id;
    String name;
    String college;
    String city;

    public Student(int id, String name, String college, String city) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.city = city;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", College: " + college + ", City: " + city;
    }
}

// Subsystem classes
class CreateStudent {
    public void create(Map<Integer, Student> db, Student student) {
        db.put(student.id, student);
        System.out.println("Student created: " + student);
    }
}

class ReadStudent {
    public void read(Map<Integer, Student> db, int id) {
        Student student = db.get(id);
        if (student != null) {
            System.out.println("Student record: " + student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}

class UpdateStudent {
    public void update(Map<Integer, Student> db, Student updatedStudent) {
        if (db.containsKey(updatedStudent.id)) {
            db.put(updatedStudent.id, updatedStudent);
            System.out.println("Student updated: " + updatedStudent);
        } else {
            System.out.println("Student not found with ID: " + updatedStudent.id);
        }
    }
}

class DeleteStudent {
    public void delete(Map<Integer, Student> db, int id) {
        if (db.remove(id) != null) {
            System.out.println("Student deleted with ID: " + id);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }
}

// Facade class
class StudentFacade {
    private Map<Integer, Student> studentDB = new HashMap<>();
    private CreateStudent creator = new CreateStudent();
    private ReadStudent reader = new ReadStudent();
    private UpdateStudent updater = new UpdateStudent();
    private DeleteStudent deleter = new DeleteStudent();

    public void createStudent(int id, String name, String college, String city) {
        Student student = new Student(id, name, college, city);
        creator.create(studentDB, student);
    }

    public void readStudent(int id) {
        reader.read(studentDB, id);
    }

    public void updateStudent(int id, String name, String college, String city) {
        Student student = new Student(id, name, college, city);
        updater.update(studentDB, student);
    }

    public void deleteStudent(int id) {
        deleter.delete(studentDB, id);
    }
}

// Client code
public class FacadeDemo {
    public static void main(String[] args) {
        StudentFacade facade = new StudentFacade();

        facade.createStudent(1, "Alice", "ABC College", "Bangalore");
        facade.createStudent(2, "Bob", "XYZ University", "Chennai");

        facade.readStudent(1);
        facade.updateStudent(1, "Alice Johnson", "ABC College", "Bangalore");
        facade.readStudent(1);

        facade.deleteStudent(2);
        facade.readStudent(2);
    }
}