package com.crm.comcast.GenericUtilies;


import  io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredLibraryclass {

	public String getJsonData (Response response,String path) {
		
		String jsonData=response.jsonPath().get(path);
		return jsonData;
	}
}
