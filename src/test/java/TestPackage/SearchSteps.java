package TestPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mymain.ByAmentiesSpec;
import mymain.ByPlacementSpec;
import mymain.ByTypeSpec;
import mymain.GeneralSpec;
import mymain.Home;
import mymain.MockEmailHolder;
import mymain.Multi;
import mymain.Search;
import io.cucumber.datatable.DataTable;


public class SearchSteps {
	ArrayList <Home> Homes=new ArrayList<Home>();
	List <Home> Result=new ArrayList<Home>();
	  Search S=new Search();
	  String string=" ";
	  String multiamentie="";
	  String multiplace="";
	  String multitype="";
	  private String subject="";
	  int num=0;
	  int num1=0;
	  int num2=0;
	  private Multi multi;
	  private GeneralSpec ament ;
	  private GeneralSpec place;
	  private GeneralSpec type;
	  private MockEmailHolder mockemailholder;
			
		 public SearchSteps(Search s,MockEmailHolder mockmail) {
				 S=s;
				 mockemailholder=mockmail;				
			 }
			 
			 public void printRes(List <Home> myResult) {
					String res;
					for(Home h:myResult)
					{
						res="Home" + "[" +"type:"+h.getType()+","+"Material:"+h.getMaterial()+","+"Placement:"+h.getPlacement()+"\n"+","+"Allow Pets:"+h.getPets()+","+"Amenties:"+h.getAmenties()+","+"\n"+"Price:"+h.getPrice()+","+"Area:"+h.getArea()+","+"Bedrooms:"+h.getBedrooms()+","+"\n"+"Bathrooms:"+h.getBathrooms()+","+"leaselenght:"+h.getLeaselength()+"]";
						Logger log = Logger.getLogger("mylogger.txt");
						ConsoleHandler handler = new ConsoleHandler();
						log.setLevel(Level.CONFIG);
						handler.setLevel(Level.CONFIG);
						handler.setFormatter(fr);
						log.addHandler(handler);
						log.config(res);
						handler.setLevel(Level.OFF);
					}
					
				}

			 Formatter fr=new Formatter() {
			        private static final String FORMAT = "%s %n";

			        @Override
			        public synchronized String format(LogRecord lr) {
			            return String.format(FORMAT,
			                    lr.getMessage()
			            );
			        }
			    };
			    

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
		S.setrepository(Homes);
		multi=new Multi(Homes);
	}

	@When("I search about home by {string} amenties")
	public void iSearchAboutHomeByamenties(String st) throws IOException, MessagingException
	{
		  string=st;
		  subject="Dear client this is the list of your amentie spec";
		  Result=S.byamenties(st);
		
}
	
	  
	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String st) throws IOException, MessagingException
	{
		  string=st;
		  subject="Dear client this is the list of your placement spec";
		  Result=S.byplacement(st);
		  
	}
	


	@When("I search about home by {string} material")
	public void iSearchAboutHomeBymaterial(String st) throws IOException, MessagingException
	{
		  string=st;
		  subject="Dear client this is the list of your material spec";
		  Result=S.bymaterial(st);
		
	}
	@When("I search about home by {string} type")
	public void iSearchAboutHomeBytype(String st) throws IOException, MessagingException
	{
		  string=st;
		  subject="Dear client this is the list of your type spec";
		  Result=S.bytype(st);
	}

	@Then("A list of homes that matches the placement specification should be returned and printed on the console")
	public void totalHomesPlacement() 
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
		System.out.println("Placement filter =>"+"\n");
		printRes(Result);
		
	}
	

	
 
    
 
    
	@Then("A list of homes that matches the material specification should be returned and printed on the console")
	public void totalHomesMaterial() 
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
		printRes(Result);
	}
	
	@Then("A list of homes that matches the type specification should be returned and printed on the console")
	public void totalHomesType() 
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
		printRes(Result);
		
	}
	
	@When("I search about home with price less than {int}")
	public void IsearchLessPrice(int Price) throws IOException, MessagingException
	{ 
		    num=Price;
		    subject="Dear client this is the list of your price spec";
		    Result=S.byPriceLess(Price);
	}
	
	@When("I search about home with price more than {int} and less than {int}")
	public void IsearchRangePrice(int LowerP,int UpperP) throws IOException, MessagingException
	{
		num1=LowerP;
		num2=UpperP;
		  subject="Dear client this is the list of your price range spec";
		Result= S.byPriceBetween(LowerP, UpperP);
	
	}
	
	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void totalHomesPrice() 
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
		printRes(Result);
		
	}
	
	@When("I search about home with area less than {int}")
	public void IsearchLessArea(int Area) throws IOException, MessagingException
	{   
		   num=Area;
		   subject="Dear client this is the list of your area spec";
		   Result= S.byAreaLess(Area);
	}
	
	@When("I search about home with area more than {int} and less than {int}")
	public void IsearchRangeArea(int LowerA,int UpperA)
	{
		
		num1=LowerA;
		num2=UpperA;
		  subject="Dear client this is the list of your area range spec";
		Result= S.byAreaBetween(LowerA, UpperA);
	}
	
	@Then("A list of homes that matches the area specification should be returned and printed on the console")
	public void totalHomesArea() 
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
					 
			printRes(Result);
			
	}
	

	@When("I search about home with {int} Number of bedrooms")
	public void iSearchAboutHomeWithNumberOfBedrooms(Integer bedrooms) throws IOException, MessagingException {     
		num=bedrooms;
		  subject="Dear client this is the list of your bedrooms spec";
		     Result= S.byBedrooms(bedrooms);
	}



	@Then("A list of homes that matches the bedrooms specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheBedroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
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
		printRes(Result);
		
		
	}


	

		@When("I search about home with {int} Number of bathrooms")
		public void iSearchAboutHomeWithNumberOfBathrooms(Integer bathrooms) throws IOException, MessagingException {
			
			num=bathrooms;
			  subject="Dear client this is the list of your bathroom spec";
    		   Result= S.byBathrooms(bathrooms);
		}


		

		@Then("A list of homes that matches the bathrooms specification should be returned and printed on the console")
		public void aListOfHomesThatMatchesTheBathroomsSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
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
		
			printRes(Result);
		
		
		}

		

			@When("I search about home By {string} Allow Pets")
			public void iSearchAboutHomeByAllowPets(String pets) throws IOException, MessagingException {
				string=pets;
				  subject="Dear client this is the list of your pets spec";
    		  Result=S.byPets(pets);
			}



			@Then("A list of homes that matches the pets specification should be returned and printed on the console")
			public void aListOfHomesThatMatchesThePetsSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
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
				printRes(Result);
			
			
			}


				@When("I search about home By {int} Lease Length")
				public void iSearchAboutHomeByLeaseLength(Integer lease) throws IOException, MessagingException {    
					num=lease;
					  subject="Dear client this is the list of your lease lenght spec";
	    		     Result= S.byLeaseLength(lease);
				}

           @Then("A list of homes that matches the leaselength specification should be returned and printed on the console")
				public void aListOfHomesThatMatchesTheLeaselengthSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
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
	            printRes(Result);
	           
					
				}
       
					
           @Then("A list of homes that matches the amenties specification should be returned and printed on the console")
	               public void aListOfHomesThatMatchesTheAmentiesSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
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
				
	              printRes(Result);
	               
           }
           
           @When("I search about home by {string} and by {string} By {string}")
           public void iSearchAboutHomeByAndByBy(String string, String string2, String string3) {
        	 multiamentie=string;
        	 multiplace=string2;
        	 multitype=string3;
        	  subject="Dear client this is the list of your multiple spec";
           	ament=new ByAmentiesSpec(string);	
           	place=new ByPlacementSpec(string2);
           	type=new ByTypeSpec (string3);
           	Result=multi.cmp(ament,place,type);
           }


           @Then("A list of homes that matches the multiple specification should be returned and printed on the console")
           public void aListOfHomesThatMatchesTheMultipleSpecificationShouldBeReturnedAndPrintedOnTheConsole()  {
           	System.out.println();
           	System.out.println("Multi filter =>"+"\n");
           	assertEquals(1,Result.size());
           
           for(Home r:Result) {
           	assertTrue(r.getAmenties().equalsIgnoreCase(multiamentie));
        	assertTrue(r.getPlacement().equalsIgnoreCase(multiplace));
        	assertTrue(r.getType().equalsIgnoreCase(multitype));
           }
           	printRes(Result);
           }
           
           
           
           
           @Then("The result should be sent to Email {string}")
           public void email(String email) throws IOException, MessagingException {
               S.sendE(subject,email,Result);
           	verify(mockemailholder.getMockmail(),times(1)).sendEmail(subject,email, Result);
           }
}	