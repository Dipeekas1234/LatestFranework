package crudOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectsTest {
	@Test
	public void readproject() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
}