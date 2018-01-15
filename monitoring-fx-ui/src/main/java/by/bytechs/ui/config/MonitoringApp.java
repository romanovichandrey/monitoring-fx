package by.bytechs.ui.config;

import by.bytechs.restService.config.RestServiceConfig;
import by.bytechs.service.config.ServiceConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = "by.bytechs.ui")
@Import({RestServiceConfig.class, ServiceConfig.class})
public class MonitoringApp extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(new Class<?>[]{MonitoringApp.class, RestServiceConfig.class, ServiceConfig.class});
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HelloWordFxml.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(rootNode));
        primaryStage.show();
    }
}
