package spring.aop.order.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.aop.order.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public String save(final String name) {
        return orderRepository.save(name);
    }
}
