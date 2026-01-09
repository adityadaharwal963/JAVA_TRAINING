import java.util.UUID;

public class FullTimeEmployee extends Employee{
    final UUID PFID;
    String employeeRole;
    Double salary;



    FullTimeEmployee(String Role, double salary){
        super();
        employeeRole = Role;
        this.salary = salary;
        PFID = UUID.randomUUID();
    }

    @Override
    void markAttendance() {
        System.out.println("Attendance for FullTime Employee marked by Scanning Device");
        this.setTotalAttendance(this.getTotalAttendance()+1);
        System.out.println("Total Days Attended: "+this.getTotalAttendance());
    }
}
