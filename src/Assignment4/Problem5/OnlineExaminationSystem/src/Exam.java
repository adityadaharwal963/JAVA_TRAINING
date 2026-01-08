import java.util.UUID;

public abstract class Exam {

    private static int examCount = 0;     // static counter
    protected final int totalMarks = 200; // final total marks
    protected final UUID examId;
    private int marks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Exam() {
        examId = UUID.randomUUID();
        examCount++;
    }

    public static int getExamCount() {
        return examCount;
    }

    public abstract void evaluate();
}
