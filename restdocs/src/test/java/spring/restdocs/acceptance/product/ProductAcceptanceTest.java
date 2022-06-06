package spring.restdocs.acceptance.product;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static spring.restdocs.acceptance.ApiDocumentUtil.getDocumentRequest;
import static spring.restdocs.acceptance.ApiDocumentUtil.getDocumentResponse;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import spring.restdocs.acceptance.AcceptanceTest;

@DisplayName("상품 관련 기능")
class ProductAcceptanceTest extends AcceptanceTest {

    @Test
    @DisplayName("아이디에 해당하는 상품을 상세 조회한다.")
    void findById_validId_productReturned() {
        // given

        // when
        final ValidatableResponse response = RestAssured
                .given(spec).log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .filter(document("find-by-id",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("id").description("상품 ID")
                        ),
                        responseFields(
                                fieldWithPath("id").description("상품 ID"),
                                fieldWithPath("name").description("상품명"),
                                fieldWithPath("price").description("가격"),
                                fieldWithPath("priceUnit").description("가격 단위")
                        )
                ))
                .when()
                .pathParam("id", 1L)
                .get("/products/{id}")
                .then().log().all();

        // then
        response
                .statusCode(HttpStatus.OK.value())
                .body("id", equalTo(1))
                .body("name", equalTo("치약"))
                .body("price", equalTo(1200))
                .body("priceUnit", equalTo("원"));
    }
}
