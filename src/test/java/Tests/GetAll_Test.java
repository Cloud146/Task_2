package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetAll_Test {

    @Test
    @Description("Get all entities")
    void testGetAllEntities() {
        Response response = given()
                .when()
                .get("/api/getAll");

        response.then()
                .statusCode(200);

        String responseBody = response.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> entities = null;
        try {
            entities = Collections.singletonList(objectMapper.readValue(responseBody, Map.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        assertEquals(1, entities.size());

        assertEquals("Заголовок сущности", entities.get(0).get("title"));
    }
}
