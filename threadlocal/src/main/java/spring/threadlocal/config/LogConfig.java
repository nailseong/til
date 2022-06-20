package spring.threadlocal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.threadlocal.config.log.Logger;
import spring.threadlocal.config.log.ThreadLocalLogger;

@Configuration
public class LogConfig {

    @Bean
    public Logger logger() {
        return new ThreadLocalLogger();
    }
}
