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
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

public class Authorization extends ExtentReportManager {
	
	//POGO class variables
	Faker faker;
	KGeN_User userPayload;
	
	//this call variables
	int authCode;
	int otp;
	String bearerToken;
	String refreshToken;
	
	@BeforeClass
	public void setup() {
		 
		faker=new Faker();
		userPayload=new KGeN_User();
		
		// Phone Number
		String[] validStartDigits = {"9", "8", "7", "6"};
		String startDigit = validStartDigits[faker.random().nextInt(validStartDigits.length)];
		userPayload.setPhone(startDigit + faker.phoneNumber().subscriberNumber(9));	
	}
	
	@Test(priority=1)
	public void testRegisterApi() {
		
		// Create JSON Object
        JSONObject requestBody = new JSONObject();
        requestBody.put("phone_number", userPayload.getPhone());
        requestBody.put("countryCode", "+91");
        
        // API Call
		Response response = KGeN_CRUD.register(requestBody.toString());
		response.then().log().body();
	
		// Extract data from response
		authCode = response.jsonPath().getInt("authCode");
		
		//Assert
		AssertJUnit.assertEquals(response.getStatusCode(), 201);	
	}
	
	@Test(priority=2)
	public void testGetOtpApi() {
		
		Response response = KGeN_CRUD.getOtp("+91"+userPayload.getPhone());
		response.then().log().body();
	
		otp = response.jsonPath().getInt("N");
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testResendOtpApi() {
		
        JSONObject requestBody = new JSONObject();
        requestBody.put("phone_number", userPayload.getPhone());
        requestBody.put("countryCode", "+91");
		
		Response response = KGeN_CRUD.resendOtp(requestBody.toString());
		response.then().log().body();
	
		authCode = response.jsonPath().getInt("authCode");
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority=4)
	public void testGetBearerTokenApi() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("phone_number", userPayload.getPhone());
        requestBody.put("countryCode", "+91");
        requestBody.put("authCode", authCode);
        requestBody.put("otp", otp);

		Response response = KGeN_CRUD.getBearerToken(requestBody.toString());
		response.then().log().body();
	
		bearerToken = response.jsonPath().getString("accessToken");
		refreshToken = response.jsonPath().getString("refreshToken");
		
		AssertJUnit.assertEquals(response.getStatusCode(), 201);
	}	

}



//<class name="api.test.UserTests_FromProperties"/>
// <class name="api.test.DataDrivenTest"/>