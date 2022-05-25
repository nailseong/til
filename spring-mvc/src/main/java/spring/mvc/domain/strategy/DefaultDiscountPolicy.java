package spring.mvc.domain.strategy;

import org.springframework.stereotype.Component;

@Component
public class DefaultDiscountPolicy implements DiscountPolicy {

    @Override
    public boolean isMatch(final int age) {
        return 19 <= age;
    }

    @Override
    public int apply(final int fare) {
        return fare;
    }
}
