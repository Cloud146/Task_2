import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetUserTest {


    @Test
    public void testGet() {
        Response response = RestAssured.get("http://localhost:8080/api/getAll");

        // Проверка статусного кода
        response.then().statusCode(200);

        // Десериализация JSON в массив объектов

    }
}
