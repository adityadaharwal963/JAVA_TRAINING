public class JsonReportGenerator implements ReportGenerator {

    @Override
    public void generateReport(Data data) {

        System.out.println("{ Name: " + data.ReportName +
                ", Content: " + data.content +
                ", Stats: " + data.stats +
                "}");
        ReportGenerator.generateTimeStamp();
        // validate generated report
        isReportValid();
    }

}
