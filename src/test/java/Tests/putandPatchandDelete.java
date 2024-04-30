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
import static io.restassured.RestAssured.given;


public class putandPatchandDelete {
	
		@Test
		public void testPost() {
			Map<String,Object> map=new HashMap<String,Object>();
//			map.put("name", "Raghav");
//		   map.put("job", "Teacher");
//		   System.out.println(map);
			JSONObject request=new JSONObject(map);
			request.put("name", "Raghav");
		   request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in";
		given().
		body(request.toJSONString()).
		when().
		put("/api/users/2").
		then().
		statusCode(200)
		.log().all();
		
		
			
		}

			}


