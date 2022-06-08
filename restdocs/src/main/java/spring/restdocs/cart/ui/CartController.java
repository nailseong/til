package spring.restdocs.cart.ui;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.restdocs.cart.dto.CartItemResponse;
import spring.restdocs.product.ui.dto.ProductResponse;

@RestController
@RequestMapping("/carts")
public class CartController {

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> getCarts() {
        final List<CartItemResponse> response = Stream.of(
                        new ProductResponse(3L, "딸기", 1200, "원"),
                        new ProductResponse(7L, "수박", 2000, "원"),
                        new ProductResponse(5L, "사과", 1600, "원")
                )
                .map(it -> new CartItemResponse(it.getId() - 2, it))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
