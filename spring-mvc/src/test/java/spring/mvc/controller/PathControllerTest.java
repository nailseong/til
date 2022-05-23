package spring.mvc.controller;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

/*
* Public 생성자가 1개인 경우
* 기본 생성자 + setter
* Query parameter 혹은 form 의 이름과 매개 변수 이름이 동일한 생성자 (dto 의 필드 이름은 상관없음)
*
*
* Public 생성자가 2개 이상인 경우
* 무조건 기본 생성자 + setter
*
* 기본 생성자만 있는 경우 -> 바인딩 실패, 에외 안 터짐
* 기본 생성자가 없는 경우 -> IllegalStateException 터짐
*/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DisplayName("@ModelAttribute 관련 학습 테스트")
class PathControllerTest {

    private static final String SOURCE = "source";
    private static final String TARGET = "target";
    private static final String AGE = "age";

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("Query parameter에 매핑되는 하나의 생성자가 존재하면 객체를 바인딩한다.")
    void primaryConstructor_OK() {
        // when
        final ValidatableResponse response = requestGet(1);

        // then
        assertSuccessCase(response);
    }

    @Test
    @DisplayName("기본 생성자와 setter 가 존재하면 객체를 바인딩한다.")
    void defaultConstructorAndSetter_OK() {
        // when
        final ValidatableResponse response = requestGet(2);

        // then
        assertSuccessCase(response);
    }

    @Test
    @DisplayName("생성자의 매개 변수 이름이 같고 필드 이름이 다르면 객체를 바인딩한다.")
    void PrimaryConstructorDifferentFieldName_OK() {
        // when
        final ValidatableResponse response = requestGet(3);

        // then
        assertSuccessCase(response);
    }

    @Test
    @DisplayName("여러 개의 public 생성자가 존재 할 때, 기본 생성자 + setter 가 존재하면 객체를 바인딩한다.")
    void manyPublicConstructor_OK() {
        // when
        final ValidatableResponse response = requestGet(4);

        // then
        assertSuccessCase(response);
    }

    @Test
    @DisplayName("기본 생성자를 포함해서 여러 개의 public 생성자가 존재 할 때, setter 가 존재하지 않으면 바인딩에 실패한다.")
    void manyPublicConstructor_NoSetter_FailToBinding() {
        // when
        final ValidatableResponse response = requestGet(5);

        // then
        assertFailCase(response);
    }

    @Test
    @DisplayName("여러 개의 public 생성자가 존재하고 기본 생성자와 setter 가 존재하지 않으면 예외를 던진다.")
    void manyPublicConstructor_NoDefaultConstructor_ExceptionThrown() {
        // when, then
        Assertions.assertThatThrownBy(() -> requestGet(6))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("기본 생성자 + setter 인 경우 필드 이름이 달라도 setter 의 이름을 query parameter 에 매칭 시키면 바인딩에 성공한다.")
    void defaultAndSetter_DifferentFieldName_FailToBinding() {
        // when
        final ValidatableResponse response = requestGet(7);

        // then
        assertSuccessCase(response);
    }

    private ValidatableResponse requestGet(final int apiVersion) {
        final Long source = 1L;
        final Long target = 2L;
        final int age = 19;

        return RestAssured.given().log().all()
                .queryParam(SOURCE, source)
                .queryParam(TARGET, target)
                .queryParam(AGE, age)
                .when()
                .get("/paths/v" + apiVersion)
                .then().log().all();
    }

    private void assertSuccessCase(final ValidatableResponse response) {
        response.statusCode(HttpStatus.OK.value())
                .body(SOURCE, equalTo(1))
                .body(TARGET, equalTo(2))
                .body(AGE, equalTo(19));
    }

    private void assertFailCase(final ValidatableResponse response) {
        response.statusCode(HttpStatus.OK.value())
                .body(SOURCE, equalTo(null))
                .body(TARGET, equalTo(null))
                .body(AGE, equalTo(0));
    }
}