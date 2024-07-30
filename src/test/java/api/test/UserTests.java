package api.test;


import api.enpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class UserTests  {
	
	
	User userPayload;
	
	public  ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeSuite
	public void reportSetUp()
	{
		//create instance of extent reports class
		 extent=new ExtentReports();
		  
		  //path for report
		  spark = new ExtentSparkReporter("Reports/Api_Test.html");
		  
		  //configuration for report
		  spark.config().setReportName("API_Automation_Report");
		  spark.config().setDocumentTitle("API Report");
		  spark.config().setTheme(Theme.DARK);
		  
		    
		  //attached the report
		  extent.attachReporter(spark);//allowing it to access all started tests, nodes and logs
		  
		  //create a test
		   test=extent.createTest("APITest");
	}
	
	
	
	//This method generate data from pojo class
	@BeforeClass
	public void setUpdata() {
		
		//faker=new Faker();
		userPayload=new User();
		
		
		userPayload.setName("morpheus");
		userPayload.setJob("leader");
		
	}
	
	
	//calling endpoints here
	@Test(priority=1)
	public void testPostUser() 
	{

		
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201,"error : Response code is not matched ");
		System.out.println("Response code is matched ");
		
		Assert.assertTrue(response.contentType().contains("application/json"),"error : contentType is not matched ");
		System.out.println("contentType is matched ");
		
		//time() is used to get response time in milliseconds
		
		 /*Assert.assertEquals(response.time(), 10,"error :maxResponseTimeInMiliseconds is not matched");
			System.out.println("maxResponseTimeInMiliseconds is matched ");*/
			
		 
		 test.pass("Post request test case pass successfully!");
		
	}
	
	@Test(priority=2)
	public void testGetSingleUser()
	{
		Response response=UserEndPoints.readSingleUser();
		response.then().log().all();
		
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.getStatusCode(), 200,"error : Response code is not matched ");
		System.out.println("Response code is matched ");
		
		Assert.assertTrue(response.contentType().contains("application/json"),"error : contentType is not matched ");
		System.out.println("contentType is matched ");
		
		//time() is used to get response time in milliseconds
		
		 /*Assert.assertEquals(response.time(), 500,"error : maxResponseTimeInMiliseconds is not matched");
			System.out.println("maxResponseTimeInMiliseconds is matched ");*/
			
		 
		 test.pass("Get single request test case pass successfully!");
		
	}
	
	
	@Test(priority=3)
	public void testGetUser()
	{
		Response response=UserEndPoints.readUser(); 
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.getStatusCode(), 200,"error : Response code is not matched ");
		System.out.println("Response code is matched ");
		
		Assert.assertTrue(response.contentType().contains("application/json"),"error : contentType is not matched ");
		System.out.println("contentType is matched ");
		
		//time() is used to get response time in milliseconds
		
		 /*Assert.assertEquals(response.time(), 500,"error : maxResponseTimeInMiliseconds is not matched");
			System.out.println("maxResponseTimeInMiliseconds is matched ");*/
			
		 
		 test.pass("Get request test case pass successfully!");
		
	}
	
	@AfterSuite
	public void exitReport()
	{
		extent.flush();
	}
	
	
	

}
