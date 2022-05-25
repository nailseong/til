package spring.mvc.acceptance;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.http.HttpStatus;

class DiscountAcceptanceTest extends AcceptanceTest {

    @ParameterizedTest
    @DisplayName("나이에 따른 할인 금액을 계산한다.")
    @CsvSource(value = {"1:0", "5:0", "6:500", "12:500", "13:800", "18:800", "19:1350"}, delimiter = ':')
    void discount(final int age, final int expected) {
        // when
        final ValidatableResponse response = RestAssured.given().log().all()
                .queryParam("age", age)
                .queryParam("fare", 1350)
                .when()
                .get("/discounts")
                .then().log().all();

        // then
        response.statusCode(HttpStatus.OK.value())
                .body("fare", equalTo(expected));
    }
}
