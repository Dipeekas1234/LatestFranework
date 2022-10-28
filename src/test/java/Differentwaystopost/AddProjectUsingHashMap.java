package Differentwaystopost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectUsingHashMap {
	//comment
	//commit by pankaj 2.47
//comment time 1:23pm
	@Test
	public void hashmappost() {
		
		HashMap Hp = new HashMap();
		Hp.put("createdBy","Smriti");
		Hp.put("projectName","Environmentp");
		Hp.put("status","completed");
		Hp.put("teamSize","5");
		given()
		.body(Hp)
		.when()
		.post("http://localhost:8085/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201)
		.log().all();
		
		
	}
}
