import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee employee = null;

        Employee.setCompanyName("Tech Solutions");
        System.out.println("Company Name: " + Employee.getCompanyName());

        int choice;
        boolean exit = false;

        while (!exit) {
            System.out.println("Employee Management Menu");
            System.out.println("1. Create Full Time Employee");
            System.out.println("2. Create Contract Employee");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Show Employee Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee Name: ");
                    String ftName = sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employee = new FullTimeEmployee(role, salary);
                    employee.setEmpName(ftName);

                    System.out.println("Full Time Employee Created");
                    System.out.println("Employee ID: " + employee.getEmpId());
                    break;

                case 2:
                    System.out.print("Enter Employee Name: ");
                    String ctName = sc.nextLine();
                    System.out.print("Enter Project Name: ");
                    String project = sc.nextLine();
                    System.out.print("Enter Payment: ");
                    double payment = sc.nextDouble();

                    employee = new ContractEmployee(project, payment);
                    employee.setEmpName(ctName);

                    System.out.println("Contract Employee Created");
                    System.out.println("Employee ID: " + employee.getEmpId());
                    break;

                case 3:
                    if (employee != null) {
                        employee.markAttendance();
                    } else {
                        System.out.println("No employee found. Create an employee first.");
                    }
                    break;

                case 4:
                    if (employee != null) {
                        System.out.println(" Employee Details");
                        System.out.println("Name: " + employee.getEmpName());
                        System.out.println("Employee ID: " + employee.getEmpId());
                        System.out.println("Total Attendance: " + employee.getTotalAttendance());
                        System.out.println("Company: " + Employee.getCompanyName());
                    } else {
                        System.out.println("No employee found.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
