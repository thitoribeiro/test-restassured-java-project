package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class RegisterUnsuccessfulTest extends BaseApiTest {

    @Test
    public void shouldFailRegisterWithoutPassword() {
        String payload = """
            {
                "username": "thito",
                "email": "thito@example.com"
            }
            """;

        RestAssured
            .given()
                .contentType(ContentType.JSON)
                .header("X-API-Key", apiKey)
                .body(payload)
                .log().all()
            .when()
                .post("/api/register")
            .then()
                .log().all()
                .statusCode(400)
                .body("error", notNullValue());
    }
}
