package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
@Test
	public void updatep() {
		
	JSONObject obj=new JSONObject();
	obj.put("createdBy", "smitha");
	obj.put("projectName", "flip");
	obj.put("status", "created");
	obj.put("teamSize", 10);
	
	given()
	.contentType(ContentType.JSON)
	.body(obj)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_1002")
	.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	}
}
