import java.util.Scanner;
import java.util.UUID;

public class ObjectiveExam extends Exam {

    public void takeObjectiveTest() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of objective questions attempted: ");
        int questionsAttempted = sc.nextInt();

        int marks = questionsAttempted;

        if (marks < totalMarks) {
            this.setMarks(totalMarks); // cap marks at totalMarks
        }
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Objective Exam");
        System.out.println("Marks Obtained: " + this.getMarks() + "/" + totalMarks);

        if (this.getMarks() < 100) {
            System.out.println("Result: FAIL");
        } else {
            System.out.println("Result: PASS");
        }
        System.out.println();
    }
}
