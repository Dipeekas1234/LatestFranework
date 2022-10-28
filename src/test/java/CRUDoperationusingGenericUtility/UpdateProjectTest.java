package CRUDoperationusingGenericUtility;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilies.EndPointLibraray;
import com.crm.comcast.GenericUtilies.IConstants;

import io.restassured.http.ContentType;
import restFullWebpojoclasses.PojoClassForAddproject;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
@Test
	public void updatep() {
	
		PojoClassForAddproject pobj=new PojoClassForAddproject("smitha","flip","created",9);
		
//	JSONObject obj=new JSONObject();
//	obj.put("createdBy", "smitha");
//	obj.put("projectName", "flip");
//	obj.put("status", "created");
//	obj.put("teamSize", 10);
	
	given()
	.contentType(ContentType.JSON)
	.body(pobj)
	.when()
	.put(IConstants.Baseurl+EndPointLibraray.updateproject+"/TY_PROJ_1002")
	.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
	
	}
}
