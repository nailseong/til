package spring.restdocs.cart.dto;

import spring.restdocs.product.ui.dto.ProductResponse;

public class CartItemResponse {

    private final Long cartId;
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
