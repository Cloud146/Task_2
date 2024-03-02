package Tests;

import Helpers.MyRequest;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class DELETE_Test {

    @Test
    void testDeleteEntity() {
        MyRequest myRequest = new MyRequest();
        myRequest.setTitle("Заголовок сущности");
        myRequest.setVerified(true);
        myRequest.setAddition(new MyRequest.Addition());
        myRequest.getAddition().setAdditionalInfo("Дополнительные сведения");
        myRequest.getAddition().setAdditionalNumber(123);
        myRequest.setImportantNumbers(new int[]{42, 87, 15});

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(myRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/create");
        response.then()
                .statusCode(200)
                .body(notNullValue());

        int entityId = response.then().extract().path("id");
        RestAssured.given()
                .delete("/delete/{id}", entityId);

        Response getResponse = RestAssured.given()
                .get("/get/{id}", entityId);

        assertEquals(404, getResponse.getStatusCode());
    }
}
