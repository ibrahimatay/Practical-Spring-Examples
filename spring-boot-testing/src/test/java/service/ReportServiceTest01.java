package service;

import app.ApplicationConfiguration;
import component.PdfReportWriter;
import model.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ReportServiceTest01 {
    @InjectMocks
    private ReportService reportService;
    @Mock
    private PdfReportWriter reportWriter;

    @Test
    public void shouldPassReportWrite() {
        reportService.execute();
        verify(reportWriter).write(ArgumentMatchers.any(Report.class), ArgumentMatchers.any());
    }
}
