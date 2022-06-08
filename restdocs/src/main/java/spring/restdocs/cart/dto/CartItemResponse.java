package spring.restdocs.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import spring.restdocs.product.ui.dto.ProductResponse;

public class CartItemResponse {

    private final Long cartId;

    @JsonProperty(value = "product")
    private final ProductResponse productResponse;

    public CartItemResponse(Long cartId, ProductResponse productResponse) {
        this.cartId = cartId;
        this.productResponse = productResponse;
    }

    public Long getCartId() {
        return cartId;
    }

    public ProductResponse getProductResponse() {
        return productResponse;
    }
}
