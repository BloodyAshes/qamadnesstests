package tests.apiTests;

import io.restassured.RestAssured;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestConfig implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        RestAssured.baseURI = "https://swapi.dev";
        RestAssured.basePath = "/api/starships/9/";
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}
