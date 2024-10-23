package api.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//to perform crud operation
public class User_CRUD {
	
//	public static Response postUser(User payload) {
//		Response response=given().contentType("application/json").body(payload)
//		.when().post(Routes.post_url);
//		return response;
//	}
//	
//	public static Response getUser(String username) {
//		Response response=given().pathParam("username",username)
//		.when().get(Routes.get_url);
//		return response;
//	}
//	
//	public static Response putUser(String username,User payload) {
//		Response response=given().pathParam("username",username).contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
//		.when().put(Routes.put_url);
//		return response;
//	}
//	
//	public static Response deleteUser(String username) {
//		Response response=given().pathParam("username",username)
//		.when().delete(Routes.delete_url);
//		return response;
//	}
}
