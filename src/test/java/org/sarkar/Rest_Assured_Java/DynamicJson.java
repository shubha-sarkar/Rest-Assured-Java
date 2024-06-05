package org.sarkar.Rest_Assured_Java;

import org.json.JSONObject;
import org.testng.annotations.Test;

import files.Payload;
import files.ReUsableMethods;

import  static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {

	@Test
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().header("Content-Type","application/json").
		body(Payload.AddBook()).
		when()
		.post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
	}
	
	@Test
	public void createUser_HashMap()
	{
		
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "Shubha");
		
		RestAssured.baseURI="https://dummy.restapiexample.com";
		
		String response = 
				given()
					.header("Content-Type","application/json")
					.body(map.toString())
					.log().all()
		
				.when()
					.post("/api/v1/create")
					
				.then()
					.log().all()
					.assertThat().statusCode(200)
					.extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("data.id").toString();
		System.out.println(id);
	}
	
	@Test
	public void createUser_JsonObject()
	{
		
		JSONObject data = new JSONObject();
		data.put("name", "Shubha");
		
		RestAssured.baseURI="https://dummy.restapiexample.com";
		
		String response = 
				given()
					.header("Content-Type","application/json")
					.body(data.toString())
		
				.when()
					.post("/api/v1/create")
					
				.then()
					.log().all().assertThat().statusCode(200)
					.extract().response().asString();
		
		JsonPath js = ReUsableMethods.rawToJson(response);
		String id = js.get("data.id").toString();
		System.out.println(id);
	}
}
