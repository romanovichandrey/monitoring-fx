package by.bytechs.ui.config;

import by.bytechs.restService.config.RestServiceConfig;
import by.bytechs.service.config.ServiceConfig;
import by.bytechs.ui.view.HelloWordOverview;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"by.bytechs.ui"})
@Import({RestServiceConfig.class, ServiceConfig.class})
public class MonitoringApp extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        launchApp(MonitoringApp.class, HelloWordOverview.class, args);
    }
}
