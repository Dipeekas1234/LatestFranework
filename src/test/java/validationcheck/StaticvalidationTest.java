package validationcheck;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticvalidationTest {
@Test
public void getstaticresponce() {
	
	//prerequisites
	String expdata="michael.lawson@reqres.in";

	
	//action
	 Response resp = when()
			 .get("https://reqres.in/api/users?page=2");
			String actdata=resp.jsonPath().get(".data[1].email");
			Assert.assertEquals(expdata, actdata);
			System.out.println("data is verified");
			resp.then().log().all();
			
}

}
