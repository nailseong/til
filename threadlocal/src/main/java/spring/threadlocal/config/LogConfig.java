package spring.threadlocal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.threadlocal.config.log.FieldLogger;
import spring.threadlocal.config.log.Logger;

@Configuration
public class LogConfig {

    @Bean
    public Logger logger() {
        return new FieldLogger();
    }
}
