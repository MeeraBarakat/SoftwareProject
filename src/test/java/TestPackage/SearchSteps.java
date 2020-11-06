package TestPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.BeforeClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.Enums;
import mymain.Home;
import mymain.Search;
import io.cucumber.datatable.DataTable;

public class SearchSteps {
	ArrayList <Home> Homes=new ArrayList<Home>();
	List <Home> Result=new ArrayList<Home>();
	Search S;
	  String string=" ";
	  int num=0;
	  int num1=0;
	  int num2=0; 
	
	@Given ("these homes are contained in the system")
public void thePriceOf(DataTable dt)
	{
	List<List<String>> list = dt.asLists();
		for(int i=0; i<list.size(); i++) {
			String []key=list.get(i).get(0).split("_");
			String []value=list.get(i).get(1).split("_");
			Home home=new Home();
			home.setType(key[0]);
			home.setMaterial(key[1]);
			home.setPlacement(key[2]);
			home.setPets(key[3]);
			home.setAmenties(key[4]);
			home.setPrice(Integer.parseInt(value[0]));
		    home.setArea(Integer.parseInt(value[1]));
			home.setBedrooms(Integer.parseInt(value[2]));
			home.setBathrooms(Integer.parseInt(value[3]));
			home.setLeaselength(Integer.parseInt(value[4]));
			Homes.add(home);
	}
		S=new Search(Homes);
	}

	@When("I search about home by {string} amenties")
	public void iSearchAboutHomeByamenties(String st)
	{
		  string=st;
		  Result=S.byamenties(st);
		
}
	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String st)
	{
		  string=st;
		  Result=S.byplacement(st);
		
	}

	@When("I search about home by {string} material")
	public void iSearchAboutHomeBymaterial(String st)
	{
		  string=st;
		  Result=S.bymaterial(st);
		
	}
	@When("I search about home by {string} type")
	public void iSearchAboutHomeBytype(String st)
	{
		  string=st;
		  Result=S.bytype(st);
	}

	@Then("A list of homes that matches the placement specification should be returned and printed on the console")
	public void totalHomesPlacement() throws IOException
	{
		if(string.equalsIgnoreCase("City")) {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getPlacement().equalsIgnoreCase(string));
			  }
	}
		else if(string.equalsIgnoreCase("Village")) {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getPlacement().equalsIgnoreCase(string));
			  }
	}
		System.out.println("All Homes = >");
		System.out.println();
		S.printRes(Homes);
		System.out.println();
		System.out.println("Placement filter =>"+"\n");
		S.printRes(Result);
		
	}
	
	@Then("A list of homes that matches the material specification should be returned and printed on the console")
	public void totalHomesMaterial() throws IOException
	{
		System.out.println();
		System.out.println("Material filter =>"+"\n");
		if(string.equalsIgnoreCase("Brick")) {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getMaterial().equalsIgnoreCase(string));
			  }
		}
		else if(string.equalsIgnoreCase("wood")) {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getMaterial().equalsIgnoreCase(string));
			  }
		}
		else {
			assertEquals(0,Result.size());
			
		}
		S.printRes(Result);
		
	}
	
	@Then("A list of homes that matches the type specification should be returned and printed on the console")
	public void totalHomesType() throws IOException
	{
		System.out.println();
		System.out.println("Type filter =>"+"\n");
		if(string.equalsIgnoreCase("APARTMENT")) {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getType().equalsIgnoreCase(string));
			  }
		}
		else {
			assertEquals(1,Result.size());
			 for(Home h:Result) {
				  assertTrue(h.getType().equalsIgnoreCase(string));
			  }
		}
		S.printRes(Result);
		
	}
	
	@When("I search about home with price less than {int}")
	public void IsearchLessPrice(int Price)
	{ 
		    num=Price;
		    Result=S.byPriceLess(Price);
	}
	
	@When("I search about home with price more than {int} and less than {int}")
	public void IsearchRangePrice(int LowerP,int UpperP)
	{
		num1=LowerP;
		num2=UpperP;
		Result= S.byPriceBetween(LowerP, UpperP);
	
	}
	
	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void totalHomesPrice() throws IOException
	{
		System.out.println();
		System.out.println("Price filter => "+"\n");
		if(num1==0 && num2==0)
		{if(num>510) {
			assertEquals(2,Result.size());
		}
		else if(num > 230) {
			assertEquals(1,Result.size());
			}
			else {
				assertEquals(0,Result.size());
				
			}
			 
		}
		
		else if(num == 0) {
			if(num1<510 && num2> 510 && num1>230) {
				assertEquals(1,Result.size());
			}
			else if(num1<230 && num2>230) {
				if(num2 >510)
				{assertEquals(2,Result.size());}
				else {
					{assertEquals(1,Result.size());}
				}
				}
			
		else {
			assertEquals(0,Result.size());
		}
		}	 
		S.printRes(Result);
		
	}
	
	@When("I search about home with area less than {int}")
	public void IsearchLessArea(int Area)
	{      num=Area;
		   Result= S.byAreaLess(Area);
	}
	
	@When("I search about home with area more than {int} and less than {int}")
	public void IsearchRangeArea(int LowerA,int UpperA)
	{
		num1=LowerA;
		num2=UpperA;
		Result= S.byAreaBetween(LowerA, UpperA);
	}
	
	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void totalHomesArea() throws IOException
	{
			System.out.println();
			System.out.println("Area filter =>"+"\n");
			if(num1==0 && num2==0)
			{
				if(num>150) {
				assertEquals(2,Result.size());
			}
			else if(num > 120) {
				assertEquals(1,Result.size());}
				else {
					assertEquals(0,Result.size());
					
				}
				 
			}
			
			else if(num == 0) {
				if(num1<150 && num2> 150 && num1>120) {
					assertEquals(1,Result.size());
				}
				else if(num1<120 && num2>120) {
					if(num2 >150)
					{assertEquals(2,Result.size());}
					else {
						{assertEquals(1,Result.size());}
					}
					}
				
			else {
				assertEquals(0,Result.size());
			}
			}
					 
			S.printRes(Result);
			
	}
	

	@When("I search about home with {int} Number of bedrooms")
	public void iSearchAboutHomeWithNumberOfBedrooms(Integer bedrooms) {
		     num=bedrooms;
		     Result= S.byBedrooms(bedrooms);
	}



	@Then("A list of homes that matches the bedrooms specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheBedroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws IOException {
		System.out.println();
		System.out.println("Bedrooms filter =>"+"\n");
		if(num==1) {
			assertEquals(0,Result.size());
			 
		}
		else if(num==2) {
			assertEquals(0,Result.size());
			 
		}
		else if(num==3) {
			assertEquals(1,Result.size());
			  for(Home h:Result) {
				  assertEquals(3,h.getBedrooms());
			  }
		}
		else if(num==4) {
			assertEquals(1,Result.size());
			  for(Home h:Result) {
				  assertEquals(4,h.getBedrooms());
			  }
		}
		else {
			assertEquals(0,Result.size());
			
		}
		S.printRes(Result);
		
		
	}


	

		@When("I search about home with {int} Number of bathrooms")
		public void iSearchAboutHomeWithNumberOfBathrooms(Integer bathrooms) {
			num=bathrooms;
    		   Result= S.byBathrooms(bathrooms);
		}


		

		@Then("A list of homes that matches the bathrooms specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheBathroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws IOException {
			System.out.println();
			System.out.println("Bathrooms filter =>"+"\n");
			if(num==1) {
				assertEquals(0,Result.size());			 
			}
			else if(num==2) {
				assertEquals(2,Result.size());
				  for(Home h:Result) {
					  assertEquals(2,h.getBathrooms());
				  }
			}
			else {
				assertEquals(0,Result.size());
				
			}
		
			S.printRes(Result);
		
		
		}

		

			@When("I search about home By {string} Allow Pets")
			public void iSearchAboutHomeByAllowPets(String pets) {
				string=pets;
    		  Result=S.byPets(pets);
			}



			@Then("A list of homes that matches the pets specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesThePetsSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws IOException {
				System.out.println();
				System.out.println("Pets filter =>" + "\n");
				if(string.equalsIgnoreCase("no")) {
					assertEquals(2,Result.size());
					 for(Home h:Result) {
						  assertTrue(h.getPets().equalsIgnoreCase(string));
					  }
				}
				else {
					assertEquals(0,Result.size());
					
				}
				S.printRes(Result);
			
			
			}


				@When("I search about home By {int} Lease Length")
				public void iSearchAboutHomeByLeaseLength(Integer lease) {
				        num=lease;
	    		     Result= S.byLeaseLength(lease);
				}



           @Then("A list of homes that matches the leaselength specification should be returned and printed on the console")
				public void aListOfHomesThatMatchesTheLeaselengthSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws IOException {
	            System.out.println();
	            System.out.println("LeaseLength filter =>" +"\n");	
	            if(num==6) {
					assertEquals(1,Result.size());
					  for(Home h:Result) {
						  assertEquals(6,h.getLeaselength());
					  }
				}
				else {
					assertEquals(1,Result.size());
					  for(Home h:Result) {
						  assertEquals(12,h.getLeaselength());
					  }
				}
	            S.printRes(Result);
	           
					
				}

					
           @Then("A list of homes that matches the amenties specification should be returned and printed on the console")
	               public void aListOfHomesThatMatchesTheAmentiesSpecificationShouldBeReturnedAndPrintedOnTheConsole() throws IOException {
	               System.out.println();
	               System.out.println("Amenties filter =>"+"\n");
	               if(string.equalsIgnoreCase("AirConditioning")) {
						assertEquals(0,Result.size());
						
					}
					else if(string.equalsIgnoreCase("Balcony")){
						assertEquals(0,Result.size());
						
					}
					else if(string.equalsIgnoreCase("Elevator")){
						assertEquals(2,Result.size());
						 for(Home h:Result) {
							  assertTrue(h.getAmenties().contains(string.toUpperCase()));
						  }
					}
					else if(string.equalsIgnoreCase("FirePlace")){
						assertEquals(1,Result.size());
						 for(Home h:Result) {
							  assertTrue(h.getAmenties().contains(string.toUpperCase()));
						  }
					}
					else if(string.equalsIgnoreCase("GarageParking")){
						assertEquals(1,Result.size());
						 for(Home h:Result) {
							  assertTrue(h.getAmenties().contains(string.toUpperCase()));
						  }
					}
					else if(string.equalsIgnoreCase("SwimmingPool")){
						assertEquals(0,Result.size());
						
					}
				
	               S.printRes(Result);
	              
				}
         
           
	
}	