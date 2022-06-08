package spring.restdocs.product.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.restdocs.product.ui.dto.ProductResponse;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable final Long id) {
        final ProductResponse response = new ProductResponse(id, "치약", 1200, "원");
        return ResponseEntity.ok(response);
    }
}
