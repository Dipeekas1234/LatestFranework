package EndToEndTestingTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restFullWebpojoclasses.PojoClassForAddproject;

import static io.restassured.RestAssured.*;

public class EndToEndTest {
	@Test
	public void Endtoend() throws SQLException
	
	{
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		
		PojoClassForAddproject add=new PojoClassForAddproject("xman", "hero"+randomNum, "created", 7);
		Response response = given().contentType(ContentType.JSON).body(add).when().post("http://localhost:8084/addProject");
		String projID = response.jsonPath().get("projectId");
		response.then().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		given()
		.pathParam("pid", projID)
		.when()
		.get("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200).log().all();
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "priya");
		jobj.put("projectName", "R15"+randomNum);
		given()
		.pathParam("run", projID)
		.contentType(ContentType.JSON).body(jobj)
		.when()
		.put("http://localhost:8084/projects/{run}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200).log().all();
		
		given()
		.pathParam("del", projID)
		.when()
		.delete("http://localhost:8084/projects/{del}")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(204).log().all();
		
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		String query="select* from project";
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			if(projID.equals(result.getString(1)))
			{
				System.out.println("not deleted");
			}
			else
			{
				System.out.println("project deleted");
				break;
			}
			
			//System.out.println(result.getString(1)+"/t"+result.getString(2)+"/t"+result.getString(3)+"/t"+result.getString(4)+"/t"+result.getString(5)+"/t"+result.getString(6));
		}
		
				
	}
}

