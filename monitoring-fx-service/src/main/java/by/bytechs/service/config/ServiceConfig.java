package by.bytechs.service.config;

import by.bytechs.restService.config.RestServiceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Romanovich Andrei
 */
@Configuration
@ComponentScan(basePackages = {"by.bytechs.service"})
@Import({RestServiceConfig.class})
public class ServiceConfig {
}