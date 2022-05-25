package spring.mvc.service;

import org.springframework.stereotype.Service;
import spring.mvc.domain.strategy.DiscountPolicyFactory;

@Service
public class DiscountService {

    private final DiscountPolicyFactory policyFactory;

    public DiscountService(final DiscountPolicyFactory policyFactory) {
        this.policyFactory = policyFactory;
    }

    public int discount(final int age, final int fare) {
        return policyFactory.findByAge(age)
                .apply(fare);
    }
}
