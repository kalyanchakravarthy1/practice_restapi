package kalyan.account;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class twitter_TestCases {

	final static String twitteruri = "https://api.twitter.com/1.1/statuses";
	final static String Consumer_Key = "AP4rZBfgLQ1NeP4bWWCKgjax1";
	final static String Consumer_Secret ="HbckqEpYhsuf8jXZsyQfMLAqCTMgn2UfJo6x6sUKBPYdZYolk4";
	final static String Access_Token ="3270318068-6vj0vwUlz7mSnhlznT5AHQSXvRJvaS4ekiEJMsq";
	final static String Access_Token_Secret	= "yMEbmWdxwYSGag1AcFHFjpff8PyN9WJYkPiunUoSqBVPk";


	
	@Test
	public void getTimeLines ( ) {
		 RestAssured.baseURI =twitteruri;
	Response resp =given().auth().oauth(Consumer_Key, Consumer_Secret, Access_Token, Access_Token_Secret)
	 .queryParam("count", "1")
	 .when().get("/home_timeline.json")
	 .then().extract().response();
	
		
		System.out.println(resp);
		
		
		
		
	}
	

	
}

