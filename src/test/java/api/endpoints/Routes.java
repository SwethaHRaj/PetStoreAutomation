package api.endpoints;

public class Routes {
	
//	//---------------------------------PET_STORE CODE-----------------------------------
//	public static String base_url="https://petstore.swagger.io/v2";
//	
//	//user module
//	public static String post_url=base_url+"/user";
//	public static String get_url=base_url+"/user/{username}";
//	public static String put_url=base_url+"/user/{username}";
//	public static String delete_url=base_url+"/user/{username}";
//	
//	//pet module
//	
//	//store module
//	
//	//---------------------------------PET_STORE CODE-----------------------------------
	
	
	
	
	//---------------------------------KGEN CODE-----------------------------------
	public static String stage_base_url="https://pre-prod.devindigg.com";
	
	// ************ Authentication ************
	
	public static String register = stage_base_url+"/authentication/register";
	public static String get_otp = stage_base_url+"/authentication/otp";
	public static String resend_otp = stage_base_url+"/authentication/resend";
	public static String get_auth = stage_base_url+"/authentication/verify";
	public static String get_refreshToken = stage_base_url+"/authentication/token/refresh";
	public static String update_phoneNumber= stage_base_url+"/authentication/phone/update";
	public static String update_email = stage_base_url+"/authentication/email/update";
	public static String get_login_tokens = stage_base_url+"/authentication/login/tokens";
	public static String whatsApp_login = stage_base_url+"/authentication/login";
}
