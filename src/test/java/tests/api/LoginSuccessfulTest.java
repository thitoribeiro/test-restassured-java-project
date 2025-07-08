package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class LoginSuccessfulTest extends BaseApiTest {

    @Test
    public void shouldLoginSuccessfully() {
        String payload = """
            {
                "email": "eve.holt@reqres.in",
                "password": "cityslicka"
            }
            """;

        RestAssured
            .given()
                .contentType(ContentType.JSON)
                .header("X-API-Key", apiKey)
                .body(payload)
                .log().all()
            .when()
                .post("/api/login")
            .then()
                .log().all()
                .statusCode(200)
                .body("token", notNullValue());
    }
}
