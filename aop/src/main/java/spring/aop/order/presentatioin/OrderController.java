package spring.aop.order.presentatioin;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.order.application.OrderService;
import spring.aop.order.presentatioin.dto.OrderResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<OrderResponse> save(@RequestParam final String name) {
        final String saveName = orderService.save(name);
        final OrderResponse response = new OrderResponse(saveName);
        return ResponseEntity.ok(response);
    }
}
