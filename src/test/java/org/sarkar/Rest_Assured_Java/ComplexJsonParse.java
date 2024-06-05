package org.sarkar.Rest_Assured_Java;
import files.Payload;
import io.restassured.path.json.JsonPath;
public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(Payload.CourcePrice());
		
		// Print no of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println("Number of Couses: "+count);
		
		// Print purchase amount
		int purchaseAccount = js.getInt("dashboard.purchaseAmount");
		System.out.println("\nPurchase Amount: "+purchaseAccount);
		
		// Print title of the first course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println("\nTitle of First Course: "+titleFirstCourse);
		
		// Print all course titles and their respective prices
		System.out.println("\nTitle of Courses");
		for (int i = 0; i < count; i++) 
		{
			String courseTitles = js.get("courses["+i+"].title");
			int courcePrice = js.get("courses["+i+"].price");
			System.out.println("Course "+(i+1)+": " +courseTitles+" || Price: "+courcePrice);
		}
		
		//Print no of copies sold by RPA course
		System.out.print("\nPrint no of copies sold by RPA course: ");
		for (int i = 0; i < count; i++) 
		{
			String courseTitles = js.get("courses["+i+"].title");
			if (courseTitles.equals("RPA"))
			{
				System.out.print(js.get("courses["+i+"].copies").toString());
				break;
			}
		}

	}

}
