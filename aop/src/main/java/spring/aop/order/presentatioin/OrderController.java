package spring.aop.order.presentatioin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.config.log.Logger;
import spring.aop.config.log.TraceStatus;
import spring.aop.order.application.OrderService;
import spring.aop.order.presentatioin.dto.OrderResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final Logger logger;

    @GetMapping
    public ResponseEntity<OrderResponse> save(@RequestParam final String name) {
        final TraceStatus status = logger.begin("OrderController.save(\"" + name + "\")");
        final OrderResponse response;
        try {
            final String saveName = orderService.save(name, status.getTrace());
            response = new OrderResponse(saveName);
        } catch (final Exception e) {
            logger.exception(status, e);
            throw e;
        }
        logger.end(status);
        return ResponseEntity.ok(response);
    }
}
