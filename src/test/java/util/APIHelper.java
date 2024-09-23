package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class APIHelper {

    public static Response sendGetRequest(String url, Map<String, String> headers) {
        return RestAssured
                .given()
                   .headers(headers)
                .when()
                    .get(url)
                .then()
                   .extract()
                   .response();

    }

    // Generic POST Request
    public static Response sendPostRequest(String url, Map<String, String> headers, Object body) {
        return RestAssured
                .given()
                  .headers(headers)
                  .body(body)
                .when()
                  .post(url)
                .then()
                  .extract()
                  .response();
    }

    // Generic PUT Request
    public static Response sendPutRequest(String url, Map<String, String> headers, Object body) {
        return RestAssured
                .given()
                .headers(headers)
                .body(body)
                .when()
                .put(url)
                .then()
                .extract()
                .response();
    }

    // Generic DELETE Request
    public static Response sendDeleteRequest(String url, Map<String, String> headers) {
        return RestAssured
                .given()
                .headers(headers)
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }
}
