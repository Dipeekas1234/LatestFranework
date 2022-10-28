package Authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class BearerTokenTest {

	@Test
	public void bearertokentest() {
		
		
		//.auth().oauth2("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")

		baseURI ="https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "sdet31restAssured");
		
		 given()
		 .auth()
		 .oauth2("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")
		 .body(jObj)
		 
		 
	    .when()
	     .post("/user/repos")
	     
	    .then().log().all();
	}
}
