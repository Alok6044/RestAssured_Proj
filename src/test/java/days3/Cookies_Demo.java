package days3;

import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.Map;


public class Cookies_Demo {
	//@Test
	void testCookies()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","AQTF6Hydq9fm-o-sdl2pbdkhBbLBk0cHVvgWMxq1Wjr_pnje5ZCIbEtJhnE")//wrong cookies value
		.log().all();
	}
	@Test
	void getCookies()
	{
		Response rs=given()
		.when()
		.get("https://www.google.com/");
		//get single cookie info
		String value=rs.getCookie("AEC");
		System.out.println("value of cookie is=="+value);
		
		//get all cookies
	Map<String,String> Cookies_value=rs.getCookies();
	System.out.println(Cookies_value.keySet());
	for(String k:Cookies_value.keySet())
	{
		String value1=rs.getCookie(k);
		System.out.println(value1);
		
	}
	}

}
