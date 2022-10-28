package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAndDeleteTest {
@Test
public void getanddelete() {
	Response allproject = when().get("http://localhost:8084/projects");
	allproject.then().assertThat().statusCode(200).log().all();
	String projId=allproject.jsonPath().get("[0].projectId");
	System.out.println(projId);
	given()
	.pathParam("projjjId", projId)
	.when()
	.delete("http://localhost:8084/projects/{projjjId}")
	.then()
	.assertThat().statusCode(204).log().all();
	
	
	
}
}
