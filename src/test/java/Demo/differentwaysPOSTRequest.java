package Demo;
/*
 * Different ways to create post request body
 * 1) post request body using Hashmap
 * 2) post request body creation using org.JSON
 * 3)post request body creation using pojo class
 * 4) post request using external json file data
 * */
import static io.restassured.module.jsv.JsonSchemaValidator.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;


public class differentwaysPOSTRequest {
	//1) post request body using Hashmap
/*@Test(priority=0)
	void testPostusingHashmap()
	{
		HashMap data=new HashMap();
		data.put("name", "alok");
		data.put("loacation", "france");
		data.put("phone", "23456");
		
		String courseArr[]={"c","c++"};
		data.put("courses", "courseArr");
		
		given()
		.contentType("applicatiom/json")
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("alok"))
		.body("location",equalTo("france"))
		.body("phone", equalTo("23456"))
		.body("courses[0]",equalTo( "c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-Type","application/json; chaeset=utf-8")
		.log().all();
		
	}

	private ResponseAwareMatcher<Response> equalTo(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	@Test(priority=1)
	void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200);
	}*/
	//2) post request body creation using org.JSON
	/*@Test
	void tesposttusingjsonlibrary()
	{
		JSONObject data=new JSONObject();
		data.put("name", "alok");
		data.put("loacation", "france");
		data.put("phone", "23456");
		
		String courseArr[]={"c","c++"};
		data.put("courses", "courseArr");
		
		given()
		.contentType("applicatiom/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("alok"))
		.body("location",equalTo("france"))
		.body("phone", equalTo("23456"))
		.body("courses[0]",equalTo( "c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-Type","application/json; chaeset=utf-8")
		.log().all();
		
	}

	public ResponseAwareMatcher<Response> equalTo(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/
	// 3)post request body creation using pojo class 
	/*@Test
	void testpostusingbyPOJO()
	{
		POjo_postrequest data=new POjo_postrequest();
		data.setPhone("254663");
		data.setName("alok");
		data.setLocation("france");
		String CoursesArr[]={"c","c++"};
		data.setCourses(CoursesArr);
		
		
		given()
		.contentType("applicatiom/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("alok"))
		.body("location",equalTo("france"))
		.body("phone", equalTo("23456"))
		.body("courses[0]",equalTo( "c"))
		.body("courses[1]",equalTo("c++"))
		.header("content-Type","application/json; chaeset=utf-8")
		.log().all();
	}

	public ResponseAwareMatcher<Response> equalTo(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/
	//4) post request using external json file data
	@Test 
	void testpostusingbyExternalJsonfile() throws FileNotFoundException
	{
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
		
		given()
		.contentType("applicatiom/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		/*.body("name",equalTo("alok"))
		.body("location",equalTo("france"))
		.body("phone", equalTo("23456"))
		.body("courses[0]",equalTo( "c"))
		.body("courses[1]",equalTo("c++"))*/
		.header("content-Type","application/json; chaeset=utf-8")
		.log().all();
	}
	
	

}

















