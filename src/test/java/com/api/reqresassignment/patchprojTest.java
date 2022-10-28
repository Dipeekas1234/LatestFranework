package com.api.reqresassignment;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class patchprojTest {
@Test
public void patchpojtest() {
	
		JSONObject jobj = new JSONObject();
		jobj.put( "name","morpheus");
		jobj.put("job","zion resident");
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.put("https://reqres.in/api/users/2")
		.then()
		
		.assertThat().contentType(ContentType.JSON)
		
		.log().all();
}
}
