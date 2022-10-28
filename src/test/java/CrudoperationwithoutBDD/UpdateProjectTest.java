package CrudoperationwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
public void Updation() {
	JSONObject obj=new JSONObject() ;
	obj.put("createdBy", "Dipeeka");
	obj.put("projectName", "lenskart1");
	obj.put("status", "Created");
	obj.put("teamSize", 10);
	
	//precondition
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(obj);
	//action
	Response responce = reqspec.put("http://localhost:8084/projects/TY_PROJ_1004");
	ValidatableResponse validate = responce.then();
	validate.assertThat().contentType(ContentType.JSON);
	validate.assertThat().statusCode(200);
	validate.log().all();
	
}
}
