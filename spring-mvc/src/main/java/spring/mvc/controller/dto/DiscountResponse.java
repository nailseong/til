package spring.mvc.controller.dto;

public class DiscountResponse {

    private final int fare;

    public DiscountResponse(final int fare) {
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }
}
