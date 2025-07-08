package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class LoginUnsuccessfulTest extends BaseApiTest {

    @Test
    public void shouldFailLoginWithoutPassword() {
        String payload = """
            {
                "email": "eve.holt@reqres.in"
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
                .statusCode(400)
                .body("error", notNullValue());
    }
}
