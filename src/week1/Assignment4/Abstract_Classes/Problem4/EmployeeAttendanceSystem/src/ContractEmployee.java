import java.util.UUID;

public class ContractEmployee extends Employee{
    final UUID PROJECT_ID;
    double payment;
    double project;

    ContractEmployee(String project, double payment){
        super();
        project = project;
        this.payment = payment;
        PROJECT_ID = UUID.randomUUID();
    }

    @Override
    void markAttendance() {
        System.out.println("Attendance for Contract Employee marked by HR");
        this.setTotalAttendance(this.getTotalAttendance()+1);
        System.out.println("Total Days Attended: "+this.getTotalAttendance());
    }
}
