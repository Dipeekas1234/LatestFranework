package ScenarioBasedqn;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtilies.EndPointLibraray;
import com.crm.comcast.GenericUtilies.IConstants;
import com.crm.comcast.GenericUtilies.JavaUtility;
import com.mysql.jdbc.Driver;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScrenarioTest {
	@Test
	public void enetoend() throws SQLException
	{
	
		
		JavaUtility num = new JavaUtility();
		int rannum = num.getRandomNum();
		
		JSONObject js =new JSONObject();
		js.put("projectName", "neverending"+rannum);
		js.put("createdBy", "endtoend");
		js.put("createdOn", "10/04/20");
		js.put("status", "still going");
		js.put("teamSize", 5);
		
		
		 Response res = given().body(js)
		.contentType(ContentType.JSON)
		.when().post(IConstants.Baseurl+EndPointLibraray.createProject);
		
		String pid=res.jsonPath().get("projectId");
		
		res.then().assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		
		given().pathParam("id", pid)
		.get(IConstants.Baseurl+EndPointLibraray.getsingleproject+"/{id}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
		
		
		JSONObject js1=new JSONObject();
		js1.put("projectName", "irobot");
		js1.put("createdBy", "robots");
		
		
		given().body(js1).contentType(ContentType.JSON)
		.when().put(IConstants.Baseurl+EndPointLibraray.updateproject+"/{id}")
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.log().all();
		
		//opening the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(IConstants.Baseurl);
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//enter the username and password
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(IConstants.appUserName);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(IConstants.appPassword);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"/dashboard/projects\"]")).click();
		
		//verify in rmgyantra GUI
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for(WebElement ele:list)
		{
		String rid=ele.getText();
			if(rid.equalsIgnoreCase(pid))
			{
				System.out.println("project is present");
				break;
			}
		}
		
		//close the browser
		driver.quit();
		
		
		//verify in database
		Driver dr=new Driver();
		DriverManager.registerDriver(dr);
		Connection con = DriverManager.getConnection(IConstants.DbUrl,IConstants.DBUsername,IConstants.DBpassword);
		Statement st = con.createStatement();
		String query="select*from projects";
		ResultSet result = st.executeQuery(query);
		
		while(result.next())
		{
		
			if(result.getString(1).contains(pid))
			{
				System.out.println("data is present");
				break;
			}
			else
		
				System.out.println("data is not present");
	
		//close the database
		con.close();
		}
		//delete the project
		when().delete(IConstants.Baseurl+EndPointLibraray.deleteproject+pid)
		.then().assertThat().statusCode(204)
		.log().all();
		
		//verify in GUI
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(IConstants.appUserName);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(IConstants.appPassword);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"/dashboard/projects\"]")).click();
		
		//verify in rmgyantra GUI
		List<WebElement> list1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for(WebElement ele1:list1)
		{
		String rid1=ele1.getText();
			if(rid1.equalsIgnoreCase(pid))
			{
				System.out.println("project is present");
			}
			else
			{
				System.out.println("data is not present");
				break;
			}
		}
		
		//close the browser
		driver.quit();
		
		//verify in the database
		
		Driver dr1=new Driver();
		DriverManager.registerDriver(dr);
		Connection con1 = DriverManager.getConnection(IConstants.DbUrl,IConstants.DBUsername,IConstants.DBpassword);
		Statement st1 = con.createStatement();
		String query1="select*from projects";
		ResultSet result1 = st.executeQuery(query);
		
		while(result1.next())
		{
		
			if(result1.getString(1).contains(pid))
			{
				System.out.println("data is present");
			}
			else
			{
				System.out.println("data is not present");
				break;
			}
		}
		
		//close the database
		con1.close();
		
		
		
		
		
		
		
	
		
		
	}
		
	
	}


