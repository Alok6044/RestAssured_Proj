package Days4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;

public class ParsingJson {
	@Test
	void TestJsonResponse()
	{
	//Approach1 for small no of data present in json file
		/*given() 
		.contentType("ContentType.JSON")
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("data[0].avatar",equalTo("https://reqres.in/img/faces/7-image.jpg"));*/
		
	//validate the json	
	Response res=given()
		 
		.contentType(ContentType.JSON )
		.when()
		.get("https://reqres.in/api/users?page=2");
		
	//Assert.assertEquals(res.getStatusCode(),200);//validation1
	//Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	//String image=res.jsonPath().get("data[0].avatar").toString();
	//Assert.assertEquals(image, "https://reqres.in/img/faces/7-image.jpg");
	//JsonObject class
	JSONObject jo=new JSONObject(res.toString());//Converting response to json object type
	boolean status=false;
	for(int i=0;i<jo.getJSONArray("data").length();i++)
	{
		String datasLastname=jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
		System.out.println(datasLastname);
		if(datasLastname.equals("Lawson"))
		{
			status=true;
			break;
		}
	}
	Assert.assertEquals(status, true);
	}

	

}
