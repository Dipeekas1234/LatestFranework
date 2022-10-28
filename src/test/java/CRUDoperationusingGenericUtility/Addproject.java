package CRUDoperationusingGenericUtility;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilies.EndPointLibraray;
import com.crm.comcast.GenericUtilies.IConstants;
import com.crm.comcast.GenericUtilies.JavaUtility;

import io.restassured.http.ContentType;
import restFullWebpojoclasses.PojoClassForAddproject;

import static  io.restassured.RestAssured.*;

import javax.xml.ws.Endpoint;

public class Addproject  {
@Test
public void create() {
	
	
	JavaUtility jlib=new JavaUtility() ;
	
	PojoClassForAddproject pobj	=new PojoClassForAddproject("pname","sam"+jlib.getRandomNum(),"Id123",2) ;
	
given()
.contentType(ContentType.JSON)
.body(pobj)

.when()
.post(IConstants.Baseurl+EndPointLibraray.createProject)
.then()
.assertThat().contentType(ContentType.JSON).statusCode(201)
.log().all();
}
}

