package CrudoperationwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProjectTest {
@Test
public void getAllProject() {
Response responce = RestAssured.get("http://localhost:8085/projects");
System.out.println(responce.getContentType());
System.out.println(responce.getHeader(""));
System.out.println(responce.getStatusCode());
System.out.println(responce.getBody());
System.out.println(responce.getTime());
ValidatableResponse validate = responce.then();
validate.log().all();


}
}
