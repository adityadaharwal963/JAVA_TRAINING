import java.util.Scanner;

public class CodingExam extends Exam {

    public void takeCodingTest() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coding questions attempted: ");
        int questionsAttempted = sc.nextInt();

        int marks = questionsAttempted * 2;

        if (marks < totalMarks) {
            this.setMarks(marks); // cap marks at totalMarks
        }
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Coding Exam");
        System.out.println("Marks Obtained: " + this.getMarks() + "/" + totalMarks);

        if (this.getMarks() < 100) {
            System.out.println("Result: FAIL");
        } else {
            System.out.println("Result: PASS");
        }
        System.out.println();
    }

}
