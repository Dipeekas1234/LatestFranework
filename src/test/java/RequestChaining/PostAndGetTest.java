package RequestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restFullWebpojoclasses.PojoClassForAddproject;

public class PostAndGetTest {
@Test
public void postandget() {
	Random random=new Random();
	int randNum = random.nextInt(1000);
	PojoClassForAddproject pobj = new PojoClassForAddproject("Bridge","shyam"+randNum,"created",25);
	Response resp = given().contentType(ContentType.JSON).body( pobj).when().post("http://localhost:8084/addproject");
	String projId=resp.jsonPath().get("projectId");
	given()
	.pathParam("projjjd", projId)
	.when()
	.get("http://localhost:8084/projects/{projjjd}")
	.then()
	.assertThat().statusCode(200).log().all();
	
	
}
}
