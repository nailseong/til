package spring.mvc.domain.strategy;

import org.springframework.stereotype.Component;

@Component
public class ChildDiscountPolicy implements DiscountPolicy {

    @Override
    public boolean isMatch(final int age) {
        return 6 <= age && age < 13;
    }

    @Override
    public int apply(final int fare) {
        return ((int) ((fare - 350) * 0.5));
    }
}
