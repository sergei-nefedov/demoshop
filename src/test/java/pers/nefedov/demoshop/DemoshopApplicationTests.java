package pers.nefedov.demoshop;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.entities.FormFactor;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoshopApplicationTests {
    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @Test
    void contextLoads() {
    }
    @Test
    public void whenCreateDesktop_thenStatus201() {
        Desktop newDesktop = new Desktop();
        newDesktop.setFormFactor(FormFactor.DESKTOP);
        newDesktop.setManufacturer("Manufactura");
        newDesktop.setPrice(20000);
        newDesktop.setQuantity(10);
        newDesktop.setSerialNumber(9999);

        given().log().body()
                .contentType("application/json").body(newDesktop)

                .when().post("/desktops/add")

                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void givenNoDesktop_whenGetDesktop_thenStatus500() {
        given().pathParam("id", 100)
                .when().get("/desktops/{id}")

                .then().log().body()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void givenDesktop_whenGetDesktop_thenStatus200() {
        long id = createTestDesktop();
        given().pathParam("id", id)

                .when().get("/desktops/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("manufacturer", equalTo("Manufactura"))
                .and().body("formFactor", equalTo("DESKTOP"))
                .and().body("price", equalTo(20000.0F))
                .and().body("quantity", equalTo(10))
                .and().body("serialNumber", equalTo(9999))
        ;
    }

    public int createTestDesktop() {
        Desktop newDesktop = new Desktop();
        newDesktop.setFormFactor(FormFactor.DESKTOP);
        newDesktop.setManufacturer("Manufactura");
        newDesktop.setPrice(20000);
        newDesktop.setQuantity(10);
        newDesktop.setSerialNumber(9999);

        int id =
        given().log().body()
                .contentType("application/json").body(newDesktop)

                .when().post("/desktops/add")

                .then().log().body()
                .extract().path("id");
        return id;
    }
}


