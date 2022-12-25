package Utils;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestApiMethods {
	public static Response getALL(String baseURL) {
		Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURL)
                .then()
                .extract().response();
		
		return response;
	}
	
	public static Response insert(String baseURL, String requestBody) {
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(baseURL)
                .then()
                .extract().response();
		
		return response;
	}
	
	public static Response update(String baseURL, String requestBody) {
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(baseURL)
                .then()
                .extract().response();
		
		return response;
	}
		
	public static Response delete(String baseURL) {
		Response response = given()
			    .header("Content-type", "application/json")
			    .when()
			    .delete(baseURL)
			    .then()
			    .extract().response();
	
		return response;
	}

}
