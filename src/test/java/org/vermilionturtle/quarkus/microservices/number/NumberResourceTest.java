package org.vermilionturtle.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;


@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/numbers")
          .then()
             .statusCode(200)
             .body(not(hasKey("generationDate")));
    }

}