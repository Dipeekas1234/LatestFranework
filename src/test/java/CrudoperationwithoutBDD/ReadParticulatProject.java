package CrudoperationwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ReadParticulatProject {
@Test
public void readparticularproject() {
	Response responce = RestAssured.get("http://localhost:8085/projects/TY_PROJ_1004");
	System.out.println(responce.getContentType());
	System.out.println(responce.getHeader(""));
	System.out.println(responce.getStatusCode());
	System.out.println(responce.getBody());
	System.out.println(responce.getTime());
	ValidatableResponse validate = responce.then();
	validate.log().all();

}
}
