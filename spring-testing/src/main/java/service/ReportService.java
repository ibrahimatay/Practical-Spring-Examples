package service;

import component.ReportWriter;
import model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Value("${report.global.name}")
    private String reportName;
    @Autowired
    public ReportWriter reportWriter;

    public void execute() {
        reportWriter.write(new Report(), reportName);
    }
}
