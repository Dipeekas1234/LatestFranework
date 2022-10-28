package Differentwaystopost;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import restFullWebpojoclasses.PojoClassForAddproject;

import static io.restassured.RestAssured.given;
import  static restFullWebpojoclasses.PojoClassForAddproject.*;

public class AddProjectusingPojo {
@Test
	public void addproject() {
		
		
		PojoClassForAddproject pojoadd = new PojoClassForAddproject("ram","nanotechnology","completed",10);
		given()
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201)
		.log().all();
		
		
	}
}
