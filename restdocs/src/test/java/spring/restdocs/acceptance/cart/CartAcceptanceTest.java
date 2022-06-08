package spring.restdocs.acceptance.cart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import spring.restdocs.acceptance.AcceptanceTest;
import spring.restdocs.cart.dto.CartItemResponse;
import spring.restdocs.product.ui.dto.ProductResponse;

class CartAcceptanceTest extends AcceptanceTest {

    @Test
    @DisplayName("카드에 포함된 모든 상품을 조회한다.")
    void getCarts() {
        // when
        final ValidatableResponse response = 상품_조회_요청();

        // then
        response.statusCode(HttpStatus.OK.value())
                .body("cartId", contains(1, 5, 3))
                .body("product.id", contains(3, 7, 5))
                .body("product.name", contains("딸기", "수박", "사과"));
    }

    @Test
    @DisplayName("카드에 포함된 모든 상품을 조회한다. - 2")
    void getCarts2() {
        // when
        final ValidatableResponse response = 상품_조회_요청();

        final List<Long> productIds = response.extract().jsonPath().getList(".", CartItemResponse.class)
                .stream()
                .map(CartItemResponse::getProductResponse)
                .map(ProductResponse::getId)
                .collect(Collectors.toList());

        // then
        assertThat(productIds).containsExactly(3L, 7L, 5L);
    }

    private ValidatableResponse 상품_조회_요청() {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/carts")
                .then().log().all();
    }
}
