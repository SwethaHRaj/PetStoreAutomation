package api.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.User_CRUD;
import api.payload.User;
import api.utilities.ExcelOperations;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	User data=new User();
	
	
	@Test(priority=1, dataProvider = "test1")	//, dataProviderClass = ExcelOperations.class)	//note line
	public void testPostUser(Object obj) {
		@SuppressWarnings("unchecked")
		HashMap<String, String>  hm=(HashMap<String, String>) obj;
		
		data.setUsername(hm.get("UserName").toString());
		data.setFirstname(hm.get("FirstName"));
		data.setLastname(hm.get("LastName"));
		data.setId(Integer.valueOf(hm.get("UserID")));
		data.setEmail(hm.get("Email"));
		data.setPassword(hm.get("Password"));
		data.setPhone(hm.get("Phone"));
		
		Response res = User_CRUD.postUser(data);
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"),"application/json");
	}
	
	@Test(priority=1, dataProvider = "test1")	//, dataProviderClass = ExcelOperations.class)	//note line
	public void getDeleteUser(Object obj) {
		@SuppressWarnings("unchecked")
		HashMap<String, String>  hm=(HashMap<String, String>) obj;
		data.setUsername(hm.get("UserName"));
		Response res = User_CRUD.getUser(hm.get("UserName"));
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

	@Test(priority=1, dataProvider = "test1")	//, dataProviderClass = ExcelOperations.class)	//note line
	public void testDeleteUser(Object obj) {
		@SuppressWarnings("unchecked")
		HashMap<String, String>  hm=(HashMap<String, String>) obj;
		data.setUsername(hm.get("UserName"));
		Response res = User_CRUD.deleteUser(hm.get("UserName"));
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@DataProvider(name="test1")
	public Object[][] dataProviderForTest1() throws EncryptedDocumentException, IOException {
		ExcelOperations excel=new ExcelOperations("sheet1");
		Object[][] obj=new Object[excel.getRowCount()][1];
		for(int i=0;i<excel.getRowCount();i++) {
			HashMap<String, String> hm=excel.getDataInHashMap(i+1);
			obj[i][0]=hm;
		}
		return obj;
	}
	
	 

}
