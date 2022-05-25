package spring.mvc.domain.strategy;

import org.springframework.stereotype.Component;

@Component
public class BabyDiscountPolicy implements DiscountPolicy {

    @Override
    public boolean isMatch(final int age) {
        return age < 6;
    }

    @Override
    public int apply(final int fare) {
        return 0;
    }
}
