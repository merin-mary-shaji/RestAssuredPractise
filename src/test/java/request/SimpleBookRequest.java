package request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoPayload.AuthAPIPayload;
import pojoPayload.UserBooksPayload;
import utilities.BaseUtils;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SimpleBookRequest extends BaseUtils{

	//static String accessToken;
	//static String orderId;
	//GET all books details
	
	public static Response GetAllBooksList() {

		try {
			response = when().get(routes.getString("List_Of_Books_URL"));
			int bookId =response.jsonPath().getInt("[0].id");
			userbookspayload.setId(bookId);
			response.then().assertThat().body(matchesJsonSchema(getAllBookJson));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public static Response GetAllBooksList_Type(String queryParam,String queryParamValue) {

		try {
			response =given().queryParam(queryParam,queryParamValue)
					.when().get(routes.getString("List_Of_Books_URL"));
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}


	public static Response GetSingleBook_ValidId() {
		try {
			response = given().pathParam("bookId", userbookspayload.getId())
					.when().get(routes.getString("Get_Single_Book_URL")+"{bookId}");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	public static Response GetSingleBook_InValidId() {
		try {
			response = given().pathParam("bookId", userbookspayload.getId())
					.when().get(routes.getString("Get_Single_Book_URL")+"{bookId}");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	public static Response AuthenticateAPIClient(AuthAPIPayload authapipayload)
	{
		try {
			response = given().contentType(ContentType.JSON).body(authapipayload)
					.when().post(routes.getString("Auth_API"));
			authapipayload.setAccessToken(response.jsonPath().getString("accessToken"));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static Response submitOrder(UserBooksPayload userbookspayload)
	{
		try {
			response = given()
					.header("Authorization","Bearer "+authapipayload.getAccessToken())
					.header("Content-Type","application/json")
					.body(userbookspayload)
					.when().post(routes.getString("Submit_Order_URL"));
			userbookspayload.setOrderId(response.jsonPath().getString("orderId"));
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	

	public static Response GetAllOrders()
	{
		
		try {
			response = given()
					.header("Authorization","Bearer "+authapipayload.getAccessToken())
					.when().get(routes.getString("Get_all_Orders_URL"));
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	public static Response GetAnOrders()
	{
		
		try {
			response = given()
					.header("Authorization","Bearer "+authapipayload.getAccessToken())
					.pathParam("orderId", userbookspayload.getOrderId())
					.when().get(routes.getString("Get_all_Orders_URL")+"{orderId}");
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	public static Response updateAnOrders(String customername)
	{
		
		try {
			response = given()
					.header("Authorization","Bearer "+authapipayload.getAccessToken())
					.pathParam("orderId", userbookspayload.getOrderId())
					.body(customername)
					.when().patch(routes.getString("Update_An_Order")+"{orderId}");
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	public static Response DeleteAnOrders()
	{
		
		try {
			response = given()
					.header("Authorization","Bearer "+authapipayload.getAccessToken())
					.pathParam("orderId", userbookspayload.getOrderId())
					.when().delete(routes.getString("Delete_An_Order")+"{orderId}");
			
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
}
