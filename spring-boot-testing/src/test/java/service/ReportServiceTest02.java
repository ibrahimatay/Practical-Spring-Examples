package service;

import app.ApplicationConfiguration;
import component.ReportWriter;
import model.Report;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ReportServiceTest02 {
    private ReportService reportService;

    @Before
    public void setUp() {
        reportService = new ReportService();
    }

    @Test
    public void shouldPassReportWrite() {
        ReportWriter reportWriter = Mockito.mock(ReportWriter.class);
        ReflectionTestUtils.setField(reportService, ReportService.class, "reportWriter", reportWriter, ReportWriter.class);

        reportService.execute();

        Mockito.verify(reportWriter).write(ArgumentMatchers.any(Report.class), ArgumentMatchers.any());
    }
}
