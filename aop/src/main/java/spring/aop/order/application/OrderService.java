package spring.aop.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.aop.config.log.ParamLogger;
import spring.aop.config.log.Trace;
import spring.aop.config.log.TraceStatus;
import spring.aop.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ParamLogger logger;

    public String save(final String name, final Trace trace) {
        final TraceStatus status = logger.beginSync(trace, "OrderService.save(\"" + name + "\")");
        final String saveName;
        try {
            saveName = orderRepository.save(name, status.getTrace());
        } catch (final Exception e) {
            logger.exception(status, e);
            throw e;
        }
        logger.end(status);
        return saveName;
    }
}
