package CRUDoperationusingGenericUtility;

 

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilies.EndPointLibraray;
import com.crm.comcast.GenericUtilies.IConstants;

import static io.restassured.RestAssured.*;

public class DeleteProject {
@Test
	public void deletepro() {
	when()
		.delete(IConstants.Baseurl+EndPointLibraray.deleteproject+"/TY_PROJ_1603")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
		
		
		
	}
}
