package spring.mvc.domain.strategy;

public interface DiscountPolicy {

    boolean isMatch(final int age);

    int apply(final int fare);
}
