package component;

import model.Report;

public interface ReportWriter {
    void write(Report report, String reportName);
}
