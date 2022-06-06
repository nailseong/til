package spring.restdocs.acceptance;

import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(RestDocumentationExtension.class)
public abstract class AcceptanceTest {

    @LocalServerPort
    private int port;

    protected RequestSpecification spec;

    @BeforeEach
    public void setUp(final RestDocumentationContextProvider contextProvider) {
        RestAssured.port = port;
        spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(contextProvider))
                .build();
    }
}
