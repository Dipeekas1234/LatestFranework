package com.api.reqresassignment;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class addprojectTest {
@Test
public void addprojtest() {
	JSONObject jobj = new JSONObject();
	jobj.put("name", "morpheus");
	jobj.put("job", "leader");
	 given()
	.contentType(ContentType.JSON)
	.when()
	.post("https://reqres.in/api/users?page=2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
