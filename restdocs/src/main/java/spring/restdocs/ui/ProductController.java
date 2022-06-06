package spring.restdocs.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.restdocs.ui.dto.ProductResponse;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable final Long id) {
        return new ProductResponse(id, "치약", 1200, "원");
    }
}
