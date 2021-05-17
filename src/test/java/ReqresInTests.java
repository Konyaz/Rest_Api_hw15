import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
public class ReqresInTests {


    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    void successUsersListTest() {
        given()
                .when()
                .get("/api/unknown")
                .then()
                .statusCode(200)
                .body("page", is(1))
                .body("total_pages", is(2))
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}