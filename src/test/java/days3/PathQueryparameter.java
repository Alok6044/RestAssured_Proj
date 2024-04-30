package days3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;


public class PathQueryparameter {
	@Test
	void  querypathparameter()
	{
		given()
		//.pathParam("myPath1","api")//path parameter
		.pathParam("myPath2","Users")//path parameter
		.queryParam("page",2)//query parameter
		.queryParam("id",5)//query parameter
		.when()
		.get("https://reqres.in/api/{myPath2}")
		.then()
		.statusCode(200)
		.log().all();
	}

	

}
