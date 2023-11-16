package stepDefinitions;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utilities.BaseUtils;

public class Hooks extends BaseUtils{
	
	@BeforeAll()
	public static void beforeScenario() throws FileNotFoundException {
	
		PrintStream stream = new PrintStream(new FileOutputStream("log.txt"));
		RestAssured.filters(RequestLoggingFilter.logRequestTo(stream));
		RestAssured.filters(ResponseLoggingFilter.logResponseTo(stream));
		//ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Pass");
		
		
	}

}
