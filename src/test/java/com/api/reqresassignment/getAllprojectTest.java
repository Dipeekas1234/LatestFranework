package com.api.reqresassignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getAllprojectTest {
@Test
public void readallproj() {
	
	when()
	.get("https://reqres.in/api/users/?page=2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
	
}
}
