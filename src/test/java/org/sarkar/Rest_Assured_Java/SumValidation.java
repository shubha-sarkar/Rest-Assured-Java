package org.sarkar.Rest_Assured_Java;
import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;
public class SumValidation {
	
	@Test
	public void sumOfCources()
	{
		int sum=0;
		JsonPath js=new JsonPath(Payload.CourcePrice());
		int count=js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			sum=sum+amount;
		}
		System.out.println(sum);
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}
}
