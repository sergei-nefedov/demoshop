package pers.nefedov.demoshop;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import pers.nefedov.demoshop.entities.*;

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
    public void whenCreateHardDrive_thenStatus201() {
        HardDrive hardDrive = new HardDrive();
        hardDrive.setCapacity(4000);
        hardDrive.setManufacturer("Manufactura");
        hardDrive.setPrice(20000);
        hardDrive.setQuantity(10);
        hardDrive.setSerialNumber(9999);

        given().log().body()
                .contentType("application/json").body(hardDrive)

                .when().post("/harddrives/add")

                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void whenMonitorDrive_thenStatus201() {
        Monitor  monitor = new Monitor();
        monitor.setDiagonalSize(19);
        monitor.setManufacturer("Manufactura");
        monitor.setPrice(20000);
        monitor.setQuantity(10);
        monitor.setSerialNumber(9999);

        given().log().body()
                .contentType("application/json").body(monitor)

                .when().post("/monitors/add")

                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void whenNotebookDrive_thenStatus201() {
        Notebook notebook = new Notebook();
        notebook.setSize(17);
        notebook.setManufacturer("Manufactura");
        notebook.setPrice(20000);
        notebook.setQuantity(10);
        notebook.setSerialNumber(9999);

        given().log().body()
                .contentType("application/json").body(notebook)

                .when().post("/notebooks/add")

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
    public void givenNoHardDrive_whenGetHardDrive_thenStatus500() {
        given().pathParam("id", 100)
                .when().get("/harddrives/{id}")

                .then().log().body()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void givenNoMonitor_whenGetMonitor_thenStatus500() {
        given().pathParam("id", 100)
                .when().get("/monitors/{id}")

                .then().log().body()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void givenNoNotebook_whenGetNotebook_thenStatus500() {
        given().pathParam("id", 100)
                .when().get("/notebooks/{id}")

                .then().log().body()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    public void givenDesktop_whenGetDesktop_thenStatus200() {
        long id = createTestDesktop(FormFactor.DESKTOP, "Manufactura", 20000, 10, 9999);
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

    @Test
    public void givenHardDrive_whenGetHardDrive_thenStatus200() {
        long id = createTestHardDrive(8000, "Manufactura", 20000, 10, 9999);
        given().pathParam("id", id)

                .when().get("/harddrives/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("manufacturer", equalTo("Manufactura"))
                .and().body("capacity", equalTo(8000))
                .and().body("price", equalTo(20000.0F))
                .and().body("quantity", equalTo(10))
                .and().body("serialNumber", equalTo(9999))
        ;
    }

    @Test
    public void givenMonitor_whenGetMonitor_thenStatus200() {
        long id = createTestMonitor(19, "Manufactura", 20000, 10, 9999);
        given().pathParam("id", id)

                .when().get("/monitors/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("manufacturer", equalTo("Manufactura"))
                .and().body("diagonalSize", equalTo(19))
                .and().body("price", equalTo(20000.0F))
                .and().body("quantity", equalTo(10))
                .and().body("serialNumber", equalTo(9999))
        ;
    }

    @Test
    public void givennotebook_whenGetNotebook_thenStatus200() {
        long id = createTestNotebook(17, "Manufactura", 20000, 10, 9999);
        given().pathParam("id", id)

                .when().get("/notebooks/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("manufacturer", equalTo("Manufactura"))
                .and().body("size", equalTo(17))
                .and().body("price", equalTo(20000.0F))
                .and().body("quantity", equalTo(10))
                .and().body("serialNumber", equalTo(9999))
        ;
    }

    @Test
    public void whenUpdateDesktop_thenStatus200() {
        long id = createTestDesktop(FormFactor.DESKTOP, "Manufactura", 20000, 10, 9999);
        Desktop newDesktop = new Desktop();
        newDesktop.setFormFactor(FormFactor.NETTOP);
        newDesktop.setManufacturer("Other");
        newDesktop.setPrice(99999);
        newDesktop.setQuantity(11);
        newDesktop.setSerialNumber(1111);
        newDesktop.setId(id);
        given().log()
                .body().contentType("application/json").body(newDesktop)

                .when().post("desktops/update")

                .then().log().body().statusCode(HttpStatus.OK.value());

        given().pathParam("id", id)

                .when().get("/desktops/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("manufacturer", equalTo("Other"))
                .and().body("formFactor", equalTo("NETTOP"))
                .and().body("price", equalTo(99999.0F))
                .and().body("quantity", equalTo(11))
                .and().body("serialNumber", equalTo(1111))
        ;
    }

    @Test
    public void whenDeleteAllDesktops_thenStatus200() {

        given().log().body().contentType("application/json")

                .when().delete("/desktops/delete/all")

                .then().log().body()
                .statusCode(HttpStatus.OK.value());

        when().get("/desktops/all")
                .then().log().body()
                .statusCode(HttpStatus.NOT_FOUND.value())

                ;
    }


    public int createTestDesktop(FormFactor formFactor, String manufacturer, double price, int quantity,
                                 long serialNumber) {
        Desktop newDesktop = new Desktop();
        newDesktop.setFormFactor(formFactor);
        newDesktop.setManufacturer(manufacturer);
        newDesktop.setPrice(price);
        newDesktop.setQuantity(quantity);
        newDesktop.setSerialNumber(serialNumber);

        int id =
        given().log().body()
                .contentType("application/json").body(newDesktop)

                .when().post("/desktops/add")

                .then().log().body()
                .extract().path("id");
        return id;
    }

    public int createTestHardDrive(int capacity, String manufacturer, double price, int quantity,
                                 long serialNumber) {
        HardDrive monitor = new HardDrive();
        monitor.setCapacity(capacity);
        monitor.setManufacturer(manufacturer);
        monitor.setPrice(price);
        monitor.setQuantity(quantity);
        monitor.setSerialNumber(serialNumber);

        int id =
                given().log().body()
                        .contentType("application/json").body(monitor)

                        .when().post("/harddrives/add")

                        .then().log().body()
                        .extract().path("id");
        return id;
    }

        public int createTestMonitor(int diagonalSize, String manufacturer, double price, int quantity,
                                 long serialNumber) {
        Monitor monitor = new Monitor();
        monitor.setDiagonalSize(diagonalSize);
        monitor.setManufacturer(manufacturer);
        monitor.setPrice(price);
        monitor.setQuantity(quantity);
        monitor.setSerialNumber(serialNumber);

        int id =
                given().log().body()
                        .contentType("application/json").body(monitor)

                        .when().post("/monitors/add")

                        .then().log().body()
                        .extract().path("id");
        return id;
    }

    public int createTestNotebook(int size, String manufacturer, double price, int quantity,
                                 long serialNumber) {
        Notebook notebook = new Notebook();
        notebook.setSize(size);
        notebook.setManufacturer(manufacturer);
        notebook.setPrice(price);
        notebook.setQuantity(quantity);
        notebook.setSerialNumber(serialNumber);

        int id =
                given().log().body()
                        .contentType("application/json").body(notebook)

                        .when().post("/notebooks/add")

                        .then().log().body()
                        .extract().path("id");
        return id;
    }
}


