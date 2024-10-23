package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.KGeN_CRUD;
import api.endpoints.User_CRUD;
import api.payload.KGeN_User;
import api.payload.User;
import io.restassured.response.Response;

public class KGeN_Tests {
	Faker faker;
	KGeN_User userPayload;
	
	@BeforeClass
	public void setup() {
		 
		faker=new Faker();
		userPayload=new KGeN_User();
		
		// Phone Number
		String[] validStartDigits = {"9", "8", "7", "6"};
		String startDigit = validStartDigits[faker.random().nextInt(validStartDigits.length)];
		userPayload.setPhone(startDigit + faker.phoneNumber().subscriberNumber(9));	
	}
	
//	@Test(priority=1)
	public void testRegister() {
		
		// Print Phone Number
		System.out.println("Phone Number : "+userPayload.getPhone());
		
		// Create JSON Object
        JSONObject requestBody = new JSONObject();
        requestBody.put("phone_number", userPayload.getPhone());
        requestBody.put("countryCode", "+91");
        
        // API Call
		Response response = KGeN_CRUD.register(requestBody.toString());
		response.then().log().body();
	
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority=2)
	public void testGetOtp() {
		
        // API Call
		Response response = KGeN_CRUD.getOtp("+91"+userPayload.getPhone());
		response.then().log().body();
	
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	

}



//<class name="api.test.UserTests_FromProperties"/>
// <class name="api.test.DataDrivenTest"/>