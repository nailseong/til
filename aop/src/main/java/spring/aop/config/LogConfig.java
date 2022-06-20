package spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.aop.config.log.FieldLogger;
import spring.aop.config.log.Logger;

@Configuration
public class LogConfig {

    @Bean
    public Logger logger() {
        return new FieldLogger();
    }
}
