package spring.mvc.domain.strategy;

import org.springframework.stereotype.Component;

@Component
public class TeenagerDiscountPolicy implements DiscountPolicy {

    @Override
    public boolean isMatch(final int age) {
        return 13 <= age && age < 19;
    }

    @Override
    public int apply(final int fare) {
        return ((int) ((fare - 350) * 0.8));
    }
}
