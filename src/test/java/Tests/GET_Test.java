package Tests;

import Helpers.MyResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class GET_Test extends BaseTest {
    @Test
    @Description("Get entity by id")
    void testGetEntityById() {
        int id = 1;

        Response response = given()
                .when()
                .get("/get/{id}", id);

        response.then()
                .statusCode(200)
                .body("title", equalTo("Заголовок сущности"))
                .body("verified", equalTo(true))
                .body("addition.additional_info", equalTo("Дополнительные сведения"))
                .body("addition.additional_number", equalTo(123))
                .body("important_numbers", contains(42, 87, 15));

        MyResponse myResponse = response.as(MyResponse.class);
    }
}
