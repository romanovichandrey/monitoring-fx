package by.bytechs.restService.config;

import by.bytechs.restService.utils.MyResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * @author Romanovich Andrei
 */
@Configuration
@ComponentScan(basePackages = {"by.bytechs.restService"})
@PropertySource("classpath:restService.properties")
public class RestServiceConfig {
    @Value("ipServer")
    private String ipServer;
    @Value("ipHardwareServer")
    private String ipHardwareServer;

    @Autowired
    private MyResponseErrorHandler myResponseErrorHandler;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(myResponseErrorHandler);
        return restTemplate;
    }
}