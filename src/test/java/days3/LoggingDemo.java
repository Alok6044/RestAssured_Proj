package days3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;


public class LoggingDemo {
	@Test
	void testLogs()
	{
		given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	//.log().all();//print all body,cookies,headers.status code
	//.log().body();//print only body
	.log().headers();//print only headers
		
	}

}
