package api.endpoints;

public class Routes {
	

//	public static String delete_url=base_url+"/user/{username}";

	
	//---------------------------------KGEN CODE-----------------------------------
	public static String stage_base_url="https://pre-prod.devindigg.com";
	
	// ************ Authentication ************
	
	public static String register = stage_base_url+"/authentication/register";
	public static String get_otp = stage_base_url+"/authentication/otp";
	public static String resend_otp = stage_base_url+"/authentication/resend";
	public static String get_bearerToken = stage_base_url+"/authentication/verify";
	public static String get_refreshToken = stage_base_url+"/authentication/token/refresh";
	public static String update_phoneNumber= stage_base_url+"/authentication/phone/update";
	public static String update_email = stage_base_url+"/authentication/email/update";
	public static String get_login_tokens = stage_base_url+"/authentication/login/tokens";
	public static String whatsApp_login = stage_base_url+"/authentication/login";
}
