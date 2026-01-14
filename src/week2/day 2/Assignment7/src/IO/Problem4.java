import java.io.*;

public class Problem4 {
    /*
    Problem Statement: Create a Java program to serialize a list of Student objects into
    `a file (students.ser) and then deserialize it to read and display the student details.
    Class Structure for Student:
    import java.io.Serializable;
    public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int rollNumber;
    private double grade;
    // Constructor, Getters, and Setters
    }`
     */

    static void serializerStudents(){
        Student student1 = new Student("RAM",1,8.9);
        Student student2 = new Student("SAM",2,8.9);
        Student student3 = new Student("OAM",3,8.9);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"))){
                outputStream.writeObject(student1);
                outputStream.writeObject(student2);
                outputStream.writeObject(student3);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.ser"))){
            Student student = (Student) inputStream.readObject();
            System.out.println(student);
            student = (Student) inputStream.readObject();
            System.out.println(student);
            student = (Student) inputStream.readObject();
            System.out.println(student);
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        serializerStudents();
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int rollNumber;
    private double grade;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade=" + grade +
                '}';
    }

    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}