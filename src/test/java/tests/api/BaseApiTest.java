package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseApiTest {

    protected static String apiKey;
    protected static String baseUrl;

    @BeforeAll
    public static void setup() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/test/resources/config.properties"));

        apiKey = props.getProperty("apiKey");
        baseUrl = props.getProperty("baseUrl");

        RestAssured.baseURI = baseUrl;
    }
}
