package validationcheck;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation {

	@Test
	public void dynamicvali() {
		
		////pre requistes
		String expData = "TY_PROJ_3035";
		String baseURI = "http://localhost";
		int port = 8084;

		//Action
		 Response resp = when()
		                   .get("/projects");

			//Action
		//Validation
			boolean flag = false;
			List<String> pIDs = resp.jsonPath().get("projectId");
			for(String projectID : pIDs)
			{
				if(projectID.equalsIgnoreCase(expData))
				{
					flag = true;
				}
			}
			
			Assert.assertTrue(flag);
			System.out.println("data verfied");
			
			resp.then().log().all();
		}
		
		
	}

