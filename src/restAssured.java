import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import files.Utils;



public class restAssured {
	Properties prop=new Properties();
	@BeforeTest
	public  void datafromfile() throws IOException {
		
		FileInputStream fis=new FileInputStream("/Users/jms/Documents/workspace/RestAssure/src/files/env.properties");
		prop.load(fis);
	
	}

	
	
@Test
	public void getPlaceAPI() {
		RestAssured.baseURI=prop.getProperty("Host");
		RestAssured.given().
	       param("location","-33.8670522,151.1957362").
	       param("radius","500").
	       param("key",prop.get("key")).
	       when().
	       get("/maps/api/place/nearbysearch/json").
	       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	       body("results[0].name",equalTo("Sydney")).and().
	       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
	       header("Server","pablo");
	       
	       
	       /*header("dfd","fsdfds").
	       cookie("dsfs","csder").
	       body()*/
	//Status code of the response
	//Content type 
	//Body
	//Header responses
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
