package api.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//to perform crud operation
public class User_CRUD_FromPropertiesFile {
	
	
	static ResourceBundle getURL_FromProperties(){		//to get url's from property file
		ResourceBundle routes=ResourceBundle.getBundle("routes");		//note
		return routes;
	}
	
	public static Response postUser(User payload) {
		
		String post_url = getURL_FromProperties().getString("post_url");
		Response response=given().contentType(ContentType.JSON).body(payload)
		.when().post(post_url);
		return response;
	}
	
	public static Response getUser(String username) {
		String get_url = getURL_FromProperties().getString("get_url");
		Response response=given().pathParam("username",username)
		.when().get(get_url);
		return response;
	}
	
	public static Response putUser(String username,User payload) {
		String put_url = getURL_FromProperties().getString("put_url");
		Response response=given().pathParam("username",username).contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
		.when().put(put_url);
		return response;
	}
	
	public static Response deleteUser(String username) {
		String delete_url = getURL_FromProperties().getString("delete_url");
		Response response=given().pathParam("username",username)
		.when().delete(delete_url);
		return response;
	}
}
