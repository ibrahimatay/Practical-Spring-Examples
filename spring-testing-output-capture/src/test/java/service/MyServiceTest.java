package service;

import com.ibrahimatay.service.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

// https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/system/OutputCaptureExtension.html
@ExtendWith(OutputCaptureExtension.class)
public class MyServiceTest {

    private final MyService myservice = new MyService();

    private static final String MESSAGE = "Hello World!";

    @Test
    public void testLogMessage(CapturedOutput output) {
        myservice.logMessage(MESSAGE);
        assertTrue(output.getOut().contains(MESSAGE));
    }
}
