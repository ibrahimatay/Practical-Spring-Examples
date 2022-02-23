package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SpringBean {
    @Value("${app.default.property}")
    private String appDefaultProperty;
    @Value("#{(T(java.lang.Math).random() * 10000).intValue()}")
    private int appRandomProperty;
    @Value("${JAVA_HOME}")
    private String javaHome;
    @Value("${MAVEN_HOME}")
    private String mavenHome;
    @Value("${user.home}")
    private String userHome;
    @Value("#{2 + 2}")
    private int additionResult;
    @Value("#{'New York'.toUpperCase()}")
    private String cityName;
    @Value("#{T(java.time.LocalDateTime).now()}")
    private LocalDateTime currentDate;

    public int getAdditionResult() {
        return additionResult;
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDateTime getCurrentDate() {
        return currentDate;
    }

    public String getUserHome() {
        return userHome;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getMavenHome() {
        return mavenHome;
    }

    public String getAppDefaultProperty() {
        return appDefaultProperty;
    }

    public int getAppRandomProperty() {
        return appRandomProperty;
    }
}
