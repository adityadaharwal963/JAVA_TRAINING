import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Coding Exam
        CodingExam codingExam = new CodingExam();
        codingExam.takeCodingTest();
        codingExam.evaluate();

        // Create Objective Exam
        ObjectiveExam objectiveExam = new ObjectiveExam();
        objectiveExam.takeObjectiveTest();
        objectiveExam.evaluate();

        // Display total exams created
        System.out.println("Total exams conducted: " + Exam.getExamCount());
    }
}
