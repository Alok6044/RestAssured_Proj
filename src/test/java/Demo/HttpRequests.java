package Demo;





import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.testng.annotations.Test;


//given()
//content type,set cookies,add auth,add parameter,set headers info etc..
//When()
//get,post,put,delete
//then()
//validate status code,extract responce,extract headers cookies& response body
//add is part of then,when u r going to add validation next

public class HttpRequests {
	int id;
	@Test(priority=1)
	void getusers()
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		//.body("page",equalTo(2))
		.log().all();//for displaying the response in console
		
	}
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name","alok");
		data.put("job", "trainer");
		
	  id=given()
	   .contentType("application/json")
	   .body(data)
	   .when()
	   .post("https://reqres.in/api/users")
	   .jsonPath().getInt("id");
	  // .then()
	  // .statusCode(201)
	   //.log().all();
	}
	@Test(priority=3,dependsOnMethods="createUser")
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","alok");
		data.put("job", "teacher");
		
	  given()
	   .contentType("application/json")
	   .body(data)
	   .when()
	   .put("https://reqres.in/api/users/2"+id)
	   
	   .then()
	  .statusCode(200)
	  .log().all();
	}
	@Test
	void deleteUser()
	{
		when()
		   .delete("https://reqres.in/api/users/2")
		   .then()
		   .statusCode(204)
		   .log().all();
		
	}

	
	}

	
	


