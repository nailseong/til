package spring.aop.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.aop.config.log.Logger;
import spring.aop.config.log.TraceStatus;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final Logger logger;

    public String save(final String name) {
        final TraceStatus status = logger.begin("OrderRepository.save(\"" + name + "\")");
        try {
            if (name.contains("exception")) {
                throw new IllegalArgumentException("예외 발생");
            }
            sleep(1000);
        } catch (final Exception e) {
            logger.exception(status, e);
            throw e;
        }
        logger.end(status);
        return name;
    }

    private void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
