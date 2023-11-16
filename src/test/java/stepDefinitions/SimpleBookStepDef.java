package stepDefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;


import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import request.SimpleBookRequest;
import requestBody.UserBookBody;
import utilities.BaseUtils;


public class SimpleBookStepDef extends BaseUtils{
	
	
	@Given("User creates request")
	public void user_creates_request() {
		baseURI = BaseURI;
		
	}
	@When("User sends HTTPS Request")
	public void user_sends_https_request() {
	   response =when().get(routes.getString("Get_Status_URL"));
	}
	@Then("User receives {int} Status code")
	public void user_receives_status_code(Integer statusCode) {
	    response.then().assertThat().statusCode(statusCode);
	   
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String statusKey, String statusValue) {
		
		Assert.assertEquals(response.jsonPath().getString("status"), statusValue);
	    //System.out.println(response.path("status"));
	}
	@When("User sends HTTPS Request to get Books")
	public void user_sends_https_request_to_get_books() {
		 SimpleBookRequest.GetAllBooksList();
		
	}
	
	@When("User sends HTTPS Request to get books with book {string} equal to {string}")
	public void user_sends_https_request_to_get_books_with_valid_book_equal_to(String queryParam, String queryParamValue) {
	   SimpleBookRequest.GetAllBooksList_Type(queryParam,queryParamValue);
	}
	
	@When("User sends HTTPS Request to get books with valid bookId")
	public void user_sends_https_request_to_get_books_with_valid_book_id() {
		SimpleBookRequest.GetSingleBook_ValidId();
	}
	@When("User sends HTTPS Request to get books with Invalid bookId")
	public void user_sends_https_request_to_get_books_with_invalid_book_id() throws IOException {
		UserBookBody.inValid_BookId();
		SimpleBookRequest.GetSingleBook_InValidId();
	}
	
	@When("User sends HTTPS Request to Register the API with a body in request")
	public void user_sends_https_request_to_register_the_api_with_a_body_in_request() throws IOException {
		authapipayload=UserBookBody.authencationBody();
		SimpleBookRequest.AuthenticateAPIClient(authapipayload);
		}
	@When("User sends HTTPS Request to Submit an order with a body in request")
	public void user_sends_https_request_to_submit_an_order_with_a_body_in_request() throws NumberFormatException, IOException {
		userbookspayload=UserBookBody.SubmitOrderBody(); 
		SimpleBookRequest.submitOrder(userbookspayload);
	}
	@When("User sends HTTPS Request to Get all book orders")
	public void user_sends_https_request_to_get_all_book_orders() {
		SimpleBookRequest.GetAllOrders(); 
	}
	@When("User sends HTTPS Request to Get a book orders")
	public void user_sends_https_request_to_get_a_book_orders() {
		SimpleBookRequest.GetAnOrders();
	}
	@When("User sends HTTPS Request to Update an book orders with body in request")
	public void user_sends_https_request_to_update_an_book_orders_with_body_in_request() {
		String Customername=UserBookBody.UpdateOrderBody();
		SimpleBookRequest.updateAnOrders(Customername);
	}
	@When("User sends HTTPS Request to Delete an book orders")
	public void user_sends_https_request_to_delete_an_book_orders() {
		
		SimpleBookRequest.DeleteAnOrders();
	}
}
