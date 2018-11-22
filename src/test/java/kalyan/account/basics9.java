package kalyan.account;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


//rahulonlinetutor@gmail.com
//https://mvnrepository.com/artifact/com.github.scribejava/scribejava-core/2.5.3

//https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis/2.5.3

public class basics9 {

	String ConsumerKey="AP4rZBfgLQ1NeP4bWWCKgjax1";
	String ConsumerSecret="HbckqEpYhsuf8jXZsyQfMLAqCTMgn2UfJo6x6sUKBPYdZYolk4";
	String Token="3270318068-6vj0vwUlz7mSnhlznT5AHQSXvRJvaS4ekiEJMsq";
	String TokenSecret="yMEbmWdxwYSGag1AcFHFjpff8PyN9WJYkPiunUoSqBVPk";
	String id;
	
	@Test
	public void getLatestTweet()
	{
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
	Response res =given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
		.queryParam("count", "1")
		.when().get("/home_timeline.json").then().extract().response();
	
	String response =res.asString();
	System.out.println(response);
	JsonPath js= new JsonPath(response);
	
	System.out.println(js.get("text"));
	System.out.println(js.get("id"));
	
	}
	}