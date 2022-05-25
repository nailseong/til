package spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.mvc.controller.dto.DiscountResponse;
import spring.mvc.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(final DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<DiscountResponse> discount(final Integer age, final Integer fare) {
        final int discountedFare = discountService.discount(age, fare);
        final DiscountResponse response = new DiscountResponse(discountedFare);
        return ResponseEntity.ok(response);
    }
}
