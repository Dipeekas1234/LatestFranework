package CrudoperationwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	@Test
	public void Create() {
		//json body
		JSONObject obj=new JSONObject() ;
		obj.put("createdBy", "Dipeeka");
		obj.put("projectName", "flipkart701");
		obj.put("status", "Created");
		obj.put("teamSize", 10);
		//precondions(body and content type)
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(obj);
		//action 
		Response responce = reqspec.post("http://localhost:8085/addProject");
		ValidatableResponse validate = responce.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		
		
		
	}
}
