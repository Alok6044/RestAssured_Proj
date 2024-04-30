package days3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class HeadersDemo {
	  // @Test
		void testHeaders()
		//in headers values of headers are almost same i.e we validate the headers but in cookies values are keep changing
		{
			given()
			.when()
			.get("https://www.google.com/")
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws")
			.log().headers();//it will print all headers here with this method
			
		}
		@Test
		void getHeaders()
		//in headers values of headers are almost same i.e we validate the headers but in cookies values are keep changing
		{
			Response re=given()
			.when()
			.get("https://www.google.com/");
			//get single header info
			String value=re.getHeader("Content-Type");
			System.out.println(value);
			//get all header info
		Headers myheaders=re.getHeaders();
		for(Header v:myheaders)
			{
			System.out.println(v.getName()+"  "+v.getValue());
		}
			
		}

}
