import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

/*
   https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/system/OutputCaptureExtension.html
   https://www.docs4dev.com/javadoc/en/org/springframework/boot/spring-boot-test/2.3.4.RELEASE/org/springframework/boot/test/system/CapturedOutput.html
   https://www.baeldung.com/junit-5-parameters
* */
@ExtendWith(OutputCaptureExtension.class)
public class OutputCaptureTest01 {
    @Test
    void test(CapturedOutput output) {
        System.out.println("ok");
        assertThat(output).contains("ok");
        System.err.println("error");
    }

    @AfterEach
    void after(CapturedOutput output) {
        assertThat(output.getOut()).contains("ok");
        assertThat(output.getErr()).contains("error");
    }
}
