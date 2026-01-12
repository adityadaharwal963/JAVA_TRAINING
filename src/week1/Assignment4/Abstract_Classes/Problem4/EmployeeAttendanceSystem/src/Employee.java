import java.util.UUID;

public abstract class Employee {
    private double totalAttendance;
    private static String companyName;
    private final UUID EMPID;
    private String empName;

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }

    public UUID getEmpId() {
        return EMPID;
    }

    protected Employee() {
        this.EMPID = UUID.randomUUID();
    }

    abstract void markAttendance();

    public double getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(double totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "totalAttendance=" + totalAttendance +
                ", EMPID=" + EMPID +
                ", empName='" + empName + '\'' +
                '}';
    }
}
