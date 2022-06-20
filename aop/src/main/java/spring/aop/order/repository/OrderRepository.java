package spring.aop.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    public String save(final String name) {
        if (name.contains("exception")) {
            throw new IllegalArgumentException("예외 발생");
        }
        sleep(1000);
        return name;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
