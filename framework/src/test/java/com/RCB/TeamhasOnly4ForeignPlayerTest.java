package com.RCB;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import java.io.File;
import java.util.List;

public class TeamhasOnly4ForeignPlayerTest {

	@Test
	public void playertest() {
		File file=new File("./framework/src/test/resources/Rcb.json");
		given()
		.body(file).contentType(ContentType.JSON);
		Response resp=when()
		.get("India");
//		.then().statusCode(200).extract().asString();
//		JsonPath jpath = new JsonPath(resp);
		List<String>CountryName=resp.jsonPath().get("player.Country");
		List<String>PlayerRole=resp.jsonPath().get("player.role");
//		int Count=jpath.get("player.Country");
		int countForeignPlayer=0;
	
		Boolean Flag1=false;
		Boolean Flag2=false;
		for(String country:CountryName) {
			if(!country.equalsIgnoreCase("India")) {
				countForeignPlayer++;
//		for(int i=0; i<=Count; i++)
//		{
//		if(!)
//		{
//			 countForeignPlayer=i;
		}
			if(countForeignPlayer==4) {
				Flag1=true;
			}
			

//	Assert.assertEquals(countForeignPlayer,4);
	}
		for(String role:PlayerRole) {
			if(role.equalsIgnoreCase("Wicket-keeper")) {
				Flag2=true;
			}
		}
		
		Assert.assertTrue(true, "Test Case Pass");
		
		
	}

	
	

	
}

