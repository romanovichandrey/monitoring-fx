package by.bytechs.ui;

import by.bytechs.service.config.ServiceConfig;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 */
@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
@Import(ServiceConfig.class)
public class MonitoringApp extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
