package com.api.reqresassignment;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getprojectTest {
@Test
public void readprojtest() {
	when()
	.get("https://reqres.in/api/users/2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
