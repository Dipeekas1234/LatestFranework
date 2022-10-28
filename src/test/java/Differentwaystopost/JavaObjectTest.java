package Differentwaystopost;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.*;

public class JavaObjectTest {
	@Test
	public void create() {

	JSONObject obj=new JSONObject();
	obj.put("createdBy", "smitha3");
	obj.put("projectName", "flip3");
	obj.put("status", "created");
	obj.put("teamSize", 10);
	
given()
.contentType(ContentType.JSON)
.body(obj)
.when()
.post("http://localhost:8084/addProject")
.then()
.assertThat().contentType(ContentType.JSON).statusCode(201)
.log().all();
}
}
