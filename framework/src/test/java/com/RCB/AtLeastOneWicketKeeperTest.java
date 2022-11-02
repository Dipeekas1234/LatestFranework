package com.RCB;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AtLeastOneWicketKeeperTest {
@Test
	public void AtLeastOneWicketKeeperest() {
	
		// TODO Auto-generated constructor stub
	File file=new File("./framework/src/test/resources/Rcb.json");
	String resp=given()
	.body(file)
	.when()
	.get("Wicket-keeper")
	.then().statusCode(200).extract().asString();
	JsonPath jpath = new JsonPath(resp);
	int count=jpath.getInt("player.role");
	int wcount=0;
	for(int i=0; i<=count; i++)
	{
		if(jpath.getString("player.role").equalsIgnoreCase("Wicket-keeper")){
			System.out.println("Wicket-keeper found");
			break;
			
			}
		
	Assert.assertEquals(wcount,"WiketKeeper");
	}
	

}
}

