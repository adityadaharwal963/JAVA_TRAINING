public class PdfReportGenerator implements ReportGenerator {
    @Override
    public void generateReport(Data data) {
        System.out.println(" Title: " + data.ReportName);
        System.out.println("Content: "+ data.content );
        System.out.println("Charts"+ data.stats);
        System.out.println("Generating PDF");
        ReportGenerator.generateTimeStamp();
        // validate generated report
        isReportValid();
    }
}
