package crudOperationWithBDD;

 

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {
@Test
	public void deletepro() {
	when()
		.delete("http://localhost:8084/TY_PROJ_1603")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
		
		
		
	}
}
