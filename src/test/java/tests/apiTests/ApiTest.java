package tests.apiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

@Listeners(TestConfig.class)

public class ApiTest {

    @Owner(value = "Vlad Matsenko")
    @Description(value = "Comparing response with Json schema")
    @Test
    public void schemaValidate(){
        given()
                .when().get()
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("schema.json")));
    }

}
