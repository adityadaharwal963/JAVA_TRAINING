public class ExcelReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(Data data) {
            System.out.println(" Title: " + data.ReportName);
            System.out.println("Description: "+ data.content );
            System.out.println("Excel Tables"+ data.stats);
            System.out.println("Generating Excel");
            ReportGenerator.generateTimeStamp();
            // validate generated report
            isReportValid();
        }

}
