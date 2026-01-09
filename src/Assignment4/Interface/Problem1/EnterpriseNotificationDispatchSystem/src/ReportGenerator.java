import java.time.LocalDateTime;

public interface ReportGenerator {
    void generateReport(Data data);
    static void generateTimeStamp(){
        System.out.println(LocalDateTime.now());
    }
    default boolean isReportValid(){
        // validation for real world report
        return true;
    }
}
