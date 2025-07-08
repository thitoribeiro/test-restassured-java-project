package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class RegisterSuccessfulTest {

    @Test
    public void debugRegister() {
        String payload = """
            {
                "email": "eve.holt@reqres.in",
                "password": "pistol"
            }
            """;

        RestAssured
            .given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
            .when()
                .post("/api/register")
            .then()
                .log().all();
    }
}
