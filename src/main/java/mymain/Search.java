package mymain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.mail.MessagingException;

public class Search {

	ArrayList <Home> repository=new ArrayList<>();
	ArrayList <Home> homes;
	ArrayList <Home> result=new ArrayList<>();
	GeneralSpec spec;
	private WebEmailService emailservice=new WebEmailService();
	private List<Home> finallist;
	
	public void setEmailservice(WebEmailService mockmail) {
		emailservice=mockmail;
		
	}
	public static final boolean PFLAG=false;
	
	
	public void setrepository(List <Home> house){
		homes= (ArrayList<Home>) house;
		repository=  (ArrayList<Home>) house;
	}
	
	
	public void sendE(String subject,String email,List<Home>re) throws IOException, MessagingException {
		emailservice.sendEmail(subject,email,re);
	}
   
	public List<Home> byplacement(String placement)  {
		spec=new ByPlacementSpec(placement);
		finallist=homeSearch(spec);
		return finallist;
		
	}
	
	
	public List<Home> bymaterial(String material)  {
		spec=new ByMaterialSpec(material);
		finallist=homeSearch(spec);
		return finallist;
	}
	public List<Home> bytype(String type)  {
		spec=new ByTypeSpec(type);
		finallist=homeSearch(spec);
		return finallist;
	}
	public List<Home> byamenties(String amentie)  {
		spec=new ByAmentiesSpec(amentie);
		finallist=homeSearch(spec);
		return finallist;
	}
	public List <Home> byAreaBetween(int area1,int area2)
	{
		spec=new ByAreaBetweenSpec( area1, area2);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	

	
	public List <Home> byPriceBetween(int area1,int area2) 
	{
		spec=new ByPriceBetweenSpec( area1, area2);
		finallist=homeSearch(spec);		
		return finallist;
		
	}
	
	public List <Home> byPriceLess(int price) 
	{
		spec=new ByPriceLessSpec(price);
		finallist=homeSearch(spec);
		return finallist;
		
	}
	
	
	public List <Home> byAreaLess(int area) 
	{
		spec=new ByAreaLessSpec(area);
		finallist=homeSearch(spec);
		return finallist;
		
	}
	
	
		public List <Home> byBathrooms(int bathrooms) 
		{
			spec=new ByBathroomsSpec(bathrooms);
			finallist=homeSearch(spec);
			return finallist;
			
		}
		
	
	public List <Home> byBedrooms(int bedrooms) 
	{
		spec=new ByBedroomsSpec(bedrooms);
		finallist=homeSearch(spec);
		return finallist;
		
	}
	
	public List <Home> byPets(String pets) 
	{
		spec=new ByPetsSpec(pets);
		finallist=homeSearch(spec);
		return finallist;
	}
	
	public List <Home> byLeaseLength(int lease) 
	{
		spec=new ByLeaseLengthSpec(lease);
		finallist=homeSearch(spec);
		return finallist;
		
	}

	public List<Home> homeSearch(GeneralSpec spec) {
		ArrayList <Home> foundHome=new ArrayList<>();
		Iterator <Home> theHomes=repository.iterator();
		while(theHomes.hasNext())
		{
			Home home=theHomes.next();
			if(spec.isSpecMatched(home) )
				foundHome.add(home);
		}
		return foundHome;
	}
	
}
