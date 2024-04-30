package Tests;

import org.testng.annotations.Test;



import io.restassured.mapper.ObjectMapper;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;

public class GetandPostExam {
	
	@Test
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
	body("data[4].first_name",equalTo("George"));
		//body("data.first_name",hasltems("George","Rachel"));
}
		


	@Test
	public void testPost() {
		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("name", "Raghav");
//	   map.put("job", "Teacher");
//	   System.out.println(map);
		JSONObject request=new JSONObject(map);
		request.put("name", "Raghav");
	   request.put("job", "Teacher");
	   request.put("id", "50");
	System.out.println(request.toJSONString());
	//baseURI="https://reqres.in/api";
	given().
	body(request.toJSONString()).
	when().
	post("https://reqres.in/api/users").
	then().
	statusCode(201)
	.log().all();
	
	
		
	}

		}

	
	
