package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_CRUD_FromPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests_FromProperties {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setup() {
		 
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());		
	}
	
	@Test(priority=1)
	public void testPostUser() {
		Response response = User_CRUD_FromPropertiesFile.postUser(userPayload);
		response.then().log().all();
	
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response response = User_CRUD_FromPropertiesFile.getUser(userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testPutUser() {
		//update data
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response = User_CRUD_FromPropertiesFile.putUser(userPayload.getUsername(),userPayload);
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfter=User_CRUD_FromPropertiesFile.getUser(userPayload.getUsername());
		AssertJUnit.assertEquals(responseAfter.getStatusCode(), 200);		
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response = User_CRUD_FromPropertiesFile.deleteUser(userPayload.getUsername());
		response.then().statusCode(200);		
	}
}
























