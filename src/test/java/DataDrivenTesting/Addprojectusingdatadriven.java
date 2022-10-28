package DataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import restFullWebpojoclasses.PojoClassForAddproject;

public class Addprojectusingdatadriven {
	
	@Test(dataProvider = "bodyData")
	
	public void create(String createdBy,String projectName,String  status,int teamSize ) {
		PojoClassForAddproject PJ=new PojoClassForAddproject(createdBy,projectName,status,teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(PJ)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON).statusCode(201)
		.log().all();
	}
		
		@DataProvider
		public Object[][] bodyData(){
			Object[][]objectarray=new Object[4][4];
			objectarray[0][0]="ram";
			objectarray[0][1]="commercial";
					objectarray[0][2]="completed";
							objectarray[0][3]="5";
							return objectarray;
		}
	
		
		
		
		
		
		
	}

