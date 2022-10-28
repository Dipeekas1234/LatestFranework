package DifferentWaysParameters;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PathParameterTest {
@Test
public void pathparamtest() {
	
	given()
	.pathParam("pid","TY-PROJ_001")
	.when()
	.get("http://localhost:8084/projects/{pid}")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
