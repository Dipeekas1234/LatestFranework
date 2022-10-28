package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2CoopSiteTest {

	@Test
	public void oauth2test() {
		
		Response responce=given()
				.formParam("client_id","blinket")
				.formParam("client_secret","a3ef27b62f7a166b31f1a3062b81abfe")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","https://blinket.com")
				.formParam("code","3766")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		 String token=responce.jsonPath().get("access_token");
		  given()
		 .auth().oauth2(token)
		 .pathParam("USER_ID",3766)
		.when()
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		//.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		.post("http://coop.apps.symfonycasts.com/api/USER_ID/barn-unlock")
		
		.then().log().all();
			
				
		
	}
}
