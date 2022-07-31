import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.system.OutputCaptureRule;

import static org.assertj.core.api.Assertions.assertThat;

/*
* https://stackoverflow.com/questions/66371530/how-can-i-test-logs-of-spring-boot-application/66378069#66378069
* */
public class OutputCaptureTest02 {
    @Rule
    public OutputCaptureRule output = new OutputCaptureRule();

    @Test
    public void test() {
        System.out.println("ok");
        assertThat(output).contains("ok");
    }
}
