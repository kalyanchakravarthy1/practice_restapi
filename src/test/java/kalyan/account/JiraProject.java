package kalyan.account;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import groovyjarjarasm.asm.tree.TryCatchBlockNode;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javafx.beans.binding.When;

public class JiraProject {

	@Test
	public static void loadProperties() {

		File file = new File("C:\\STUDY\\Automation\\workspace\\kalyan.account\\projectfile.properties");
		FileInputStream fileinput = null;

		try {
			fileinput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileinput);
			// System.out.println(prop.getProperty("JIRAHOST"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		RestAssured.baseURI = "http://192.168.134.130:8080";
		Response response = given().auth().basic("kalyanchakravarthy540@gmail.com", "redhat").when()
				.get("/rest/api/2/dashboard");
		response.jsonPath().toString();
		// System.out.println("****"+response+"******");

	}

	@Test
	public static void createSessionID() {

		RestAssured.baseURI = "http://192.168.134.130:8080";
		Response res1 = given().header("content-type", "application/json")
				.body("{\"username\": \"kalyanchakravarthy540@gmail.com\",\"password\": \"redhat\"}").when()
				.post("/rest/auth/1/session").then().assertThat().statusCode(200).extract().response();

		String str = res1.toString();
		System.out.println(res1);

	}

}
