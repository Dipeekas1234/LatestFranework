package RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restFullWebpojoclasses.PojoClassForAddproject;

import static io.restassured.RestAssured.*;

public class PostAndDeleteTest {
@Test
public void postanddelete() {
	
	Random random=new Random();
	int ranNum=random.nextInt();
	//creating a project 
	PojoClassForAddproject pobj = new PojoClassForAddproject("metro","radha"+ranNum,"created",7);
	Response resp = given().contentType(ContentType.JSON).body( pobj).when().post("http://localhost:8084/addproject");
	//capturing project Id using json path 
			String projId=resp.jsonPath().get("projectId");
  //create a delete request and pass projId as path parameter
			given()                                                                                                          
			.pathParam("projjjd", projId);
			when()
			.delete("http://localhost:8084/projects/{projjjd}")
			.then()
			.assertThat().statusCode(204).log().all();
	
	
}
}
