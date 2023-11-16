package utilities;

import java.io.File;
import java.util.ResourceBundle;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoPayload.AuthAPIPayload;
import pojoPayload.UserBooksPayload;

public class BaseUtils {

	public static ResourceBundle routes = ResourceBundle.getBundle("Routes");
	public static UserBooksPayload userbookspayload = new UserBooksPayload();
	public static AuthAPIPayload authapipayload =new AuthAPIPayload();
	public static ExcelUtils excelutils=new ExcelUtils(routes.getString("Excel_Path"));
	public static File getAllBookJson=new File(routes.getString("Book_Detail_SchemaPath"));
	
	public static RequestSpecification request;
	public static Response response;
	public static String  BaseURI = routes.getString("BaseUrl");
	
	
}
