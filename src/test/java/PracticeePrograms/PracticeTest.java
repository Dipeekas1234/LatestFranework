package PracticeePrograms;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class PracticeTest {

	@Test
	public void getstaticResponce() {
	
	String expdata="michael.lawson@reqres.in";
	Response resp=when()
			.get("https://reqres.in/api/users?page=2");
	String actdata=resp.jsonPath().get(".data[1].email");
	Assert.assertEquals(expdata,actdata);
	resp.then().log().all();
	        

}
}
