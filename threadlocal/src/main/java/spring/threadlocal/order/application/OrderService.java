package spring.threadlocal.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.threadlocal.config.log.Logger;
import spring.threadlocal.config.log.TraceStatus;
import spring.threadlocal.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final Logger logger;

    public String orderItem(final String name) {
        final TraceStatus status = logger.begin("OrderService.orderItem(\"" + name + "\")");
        final String saveName;
        try {
            saveName = orderRepository.save(name);
        } catch (final Exception e) {
            logger.exception(status, e);
            throw e;
        }
        logger.end(status);
        return saveName;
    }
}
