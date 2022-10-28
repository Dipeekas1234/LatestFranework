package DifferentWaysParameters;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryparameterTest {

	@Test
	public void queryparamtest() {
		String BaseUri="https://reqres.in";
		given()
		.queryParam("page",2 )
		.when()
		.get(BaseUri+"/api/users")
		.then()
		.log().all();
		
	}
}
