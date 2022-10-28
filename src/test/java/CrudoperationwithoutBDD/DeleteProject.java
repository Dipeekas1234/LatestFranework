package CrudoperationwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
@Test
public void delete() {
	Response responce = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_407");
	ValidatableResponse validate = responce.then();
	validate.assertThat().statusCode(204);
	validate.log().all();
	
}
}
