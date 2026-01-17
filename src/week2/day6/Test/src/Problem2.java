public class Problem2 {

    public static void main(String[] args) {
        new Student("ram",85).calculateGrade();
        new Student("sam",65).calculateGrade();
        new Student("dam",40).calculateGrade();
    }
}

class Student{
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void calculateGrade(){
        System.out.println(this.name+" got:");
        if(this.marks>80){
            System.out.println("Grade A");
        }else if(this.marks>60){
            System.out.println("Grade B");
        }else{
            System.out.println("Grade C");
        }
    }
}