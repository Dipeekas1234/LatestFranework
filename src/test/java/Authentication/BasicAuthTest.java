package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthTest {
@Test

public void basicAuthtest() {
	
	  //String baseUri = "http://localhost:8084";
	baseURI="http://localhost";
	 port=8084;
	 given()
	.auth().basic("rmgyantra","rmgy@9999")
	.when()
	.get("/login")
	.then()
	.assertThat().statusCode(202).log().all();
	
}
}
