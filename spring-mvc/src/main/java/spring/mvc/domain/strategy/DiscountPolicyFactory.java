package spring.mvc.domain.strategy;

import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class DiscountPolicyFactory {

    private final Set<DiscountPolicy> policies;

    public DiscountPolicyFactory(final Set<DiscountPolicy> policies) {
        this.policies = policies;
    }

    public DiscountPolicy findByAge(final int age) {
        return policies.stream()
                .filter(it -> it.isMatch(age))
                .findFirst()
                .orElseThrow();
    }
}
