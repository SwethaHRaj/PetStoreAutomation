package api.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import api.payload.KGeN_User;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//to perform crud operation
public class KGeN_CRUD {
	
	// ************ Authentication ************
	
	public static Response register(String payload) {
		Response response = given()
				.contentType("application/json")
				.body(payload)
				.when().post(Routes.register);
		return response;
	}
	
	public static Response getOtp(String phoneNumber) {
		Response response = given()
				.contentType("application/json")
				.header("x-client-id", "API-Backend") 
				.header("x-client-secret", "qwdyan0xiDV4CXnpMFy7gv62EzAw7YJM")
				.queryParams("phoneNumber", phoneNumber)
				.when().get(Routes.get_otp);
		return response;
	}
	
	public static Response resendOtp(String payload) {
		Response response = given()
				.contentType("application/json")
				.body(payload)
				.when().post(Routes.resend_otp);
		return response;
	}
	
	public static Response getBearerToken(String payload) {
		Response response = given()
				.contentType("application/json")
				.body(payload)
				.when().post(Routes.get_bearerToken);
		return response;
	}
	
}
