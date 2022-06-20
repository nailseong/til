package spring.threadlocal.order.presentatioin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.threadlocal.config.log.Logger;
import spring.threadlocal.config.log.TraceStatus;
import spring.threadlocal.order.application.OrderService;
import spring.threadlocal.order.presentatioin.dto.OrderResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final Logger logger;

    @GetMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestParam final String name) {
        final TraceStatus status = logger.begin("OrderController.createOrder(\"" + name + "\")");
        final OrderResponse response;
        try {
            final String saveName = orderService.orderItem(name);
            response = new OrderResponse(saveName);
        } catch (final Exception e) {
            logger.exception(status, e);
            throw e;
        }
        logger.end(status);
        return ResponseEntity.ok(response);
    }
}
