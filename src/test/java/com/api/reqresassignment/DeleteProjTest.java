package com.api.reqresassignment;





import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjTest {
@Test
	public void deleteprojtest() {
	 when()
	.delete("https://reqres.in/api/users/2")
	.then()
	.assertThat()
	.log().all();

	
	
	}
}
