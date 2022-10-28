package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restFullWebpojoclasses.PojoClassForAddproject;

public class PostAndPutTest {
@Test
public void postandput() {
	Random random=new Random();
	int ranNum=random.nextInt();
	PojoClassForAddproject pobj = new PojoClassForAddproject("metro","radha"+ranNum,"created",7);
	Response resp = given().contentType(ContentType.JSON).body( pobj).when().post("http://localhost:8084/addproject");
			String projId=resp.jsonPath().get("projectId"); 
			
			PojoClassForAddproject pobj1=new PojoClassForAddproject("Environment","radha"+ranNum,"created",7);
			
			given()                                                                                                          
			.pathParam("projjjd", projId)
			.contentType(ContentType.JSON)
			.body(pobj1)
			.when()
			.put("http://localhost:8084/projects/{projjjd}")
			.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
}
}
