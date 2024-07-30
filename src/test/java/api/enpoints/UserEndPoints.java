package api.enpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payloads.User;
import io.restassured.http.ContentType;

//Created for perform Create, Read request the user API

public class UserEndPoints {
	
	//Implementation of post request
	public static Response createUser(User payload)
	{
	
		Response response=given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		    .post(Routes.create_user_url);
		
		return response;		
	}
	
	//Implementation of get single request
	public static Response readSingleUser()
	{
	
		Response response=given()
				
		.when()
		    .get(Routes.get_single_user_url);
		
		return response;		
	}
	
	//Implementation of get request
		public static Response readUser()
		{
		
			Response response=given()
				
			.when()
			    .get(Routes.get_user_url);
			
			return response;		
		}
	
	
	

}
