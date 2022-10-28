package Differentwaystopost;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectUsingJsonFile {

	@Test
	public void createjsonfile() {
		
	File file=new File("./src/test/resources/snap.json");
	given()
	.body(file)
	.when()
	.post("http://localhost:8085/addProject")
	.then()
	.assertThat().contentType(ContentType.JSON).statusCode(201)
	.log().all();
	
	
		
	}
}
