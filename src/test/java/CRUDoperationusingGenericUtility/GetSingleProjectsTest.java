package CRUDoperationusingGenericUtility;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilies.EndPointLibraray;
import com.crm.comcast.GenericUtilies.IConstants;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectsTest {
	@Test
	public void readproject() {
		when()
		.get(IConstants.Baseurl+EndPointLibraray.getsingleproject+"/TY_PROJ_1603")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}
}