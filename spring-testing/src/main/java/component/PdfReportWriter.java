package component;

import model.Report;
import org.springframework.stereotype.Component;

@Component
public class PdfReportWriter implements ReportWriter{
    public void write(Report report, String reportName) {
        System.out.println("it is written pdf report");
    }
}
