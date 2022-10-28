package validationusingHamcrust;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ResponceTimevalidation {
@Test
public void responcetimevalidation() {
	
	when()
	.get("http://localhost:8084/projects")
	.then()
	//.assertThat().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS)
	//for validation
	
	//.assertThat().body("[0].projectName",Matchers.equalTo("holy")).log().all();
	.assertThat().time(Matchers.lessThan(50L),TimeUnit.MILLISECONDS)
	.log().all();
	
}
	
}

