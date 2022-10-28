package ScenarioBasedqn;

import static  io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restFullWebpojoclasses.PojoClassForAddproject;

public class EndToEndScenarion2 {

	@Test
	public void endtoend() throws SQLException {
		JavaUtility jlib=new JavaUtility ();
		
		//create a project
		
		PojoClassForAddproject poj = new PojoClassForAddproject("jasmine","zomato"+jlib.getRandomNum(),"on going",5);
		 Response res = given().body(poj)
					.contentType(ContentType.JSON)
					.when().post(IConstants.Baseurl+EndPointLibraray.createProject);
		 String pid=res.jsonPath().get("projectId");
		 
		 res.then().assertThat().statusCode(201).contentType(ContentType.JSON)
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
			//update the project
	        JSONObject js1=new JSONObject();
			js1.put("projectName", "irobot");
			js1.put("createdBy", "robots");
			
			
			given().body(js1).contentType(ContentType.JSON)
			.when().put(IConstants.Baseurl+EndPointLibraray.updateproject+"/{id}")
			.then().assertThat().statusCode(200).contentType(ContentType.JSON)
			.log().all();
			
			//enter the username and password
			driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(IConstants.appUserName);
			driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(IConstants.appPassword);
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			driver.findElement(By.xpath("//a[@href=\"/dashboard/projects\"]")).click();
			//verify in rmgyantra GUI
			List<WebElement> list1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			for(WebElement ele:list1)
			{
			String rid=ele.getText();
				if(rid.equalsIgnoreCase(pid))
				{
					System.out.println("project is present");
					break;
				}
			}
			
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
			
	}
}
