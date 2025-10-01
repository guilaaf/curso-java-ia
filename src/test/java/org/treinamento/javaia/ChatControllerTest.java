package org.treinamento.javaia;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ChatControllerTest {

    @Test
    public void testInfoEndpoint() {
        given()
                .when().get("/chat")
                .then()
                .statusCode(200)
                .body(containsString("O chat está no ar"));
    }

    @Test
    public void testChatEndpoint() {
        given()
                .contentType("application/json")
                .body("{\"message\": \"Olá, como você está?\"}")
                .when().post("/chat")
                .then()
                .statusCode(200)
                .body(containsString("Você disse"));
    }

    @Test
    public void testChatEndpointWithEmptyMessage() {
        given()
                .contentType("application/json")
                .body("{\"message\": \"\"}")
                .when().post("/chat")
                .then()
                .statusCode(200)
                .body("response", containsString("mensagem válida"));
    }

}
