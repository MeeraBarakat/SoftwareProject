package mymain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Search {
	List <Home> repository=new ArrayList<>();
	private ArrayList <Home> foundHome;
	List <Home> homes;
	ArrayList <Home> result=new ArrayList<>();
	GeneralSpec spec;
	public static final boolean PFLAG=false;
	
	
   public Search(List <Home> house){
		homes=house;
		repository=house;
	}
   
   
	public void printRes(List <Home> myResult) {
		String res;
		for(Home h:myResult)
		{
			res="Home" + "[" +"type:"+h.getType()+","+"Material:"+h.getMaterial()+","+"Placement:"+h.getPlacement()+"\n"+","+"Allow Pets:"+h.getPets()+","+"Amenties:"+h.getAmenties()+","+"\n"+"Price:"+h.getPrice()+","+"Area:"+h.getArea()+","+"Bedrooms:"+h.getBedrooms()+","+"\n"+"Bathrooms:"+h.getBathrooms()+","+"leaselenght:"+h.getLeaselength()+"]";
			System.out.println(res);
			System.out.println();
		}
		
	}
	public List<Home> byplacement(String placement) {
		spec=new ByPlacementSpec(placement);
		homeSearch(spec);
		return foundHome ;
	}
	public List<Home> bymaterial(String material) {
		spec=new ByMaterialSpec(material);
		homeSearch(spec);
		return foundHome ;
	}
	public List<Home> bytype(String type) {
		spec=new ByTypeSpec(type);
		homeSearch(spec);
		return foundHome ;
	}
	public List<Home> byamenties(String amentie) {
		spec=new ByAmentiesSpec(amentie);
		homeSearch(spec);
		return foundHome ;
	}
	public List <Home> byAreaBetween(int area1,int area2)
	{
		spec=new ByAreaBetweenSpec( area1, area2);
		homeSearch(spec);
		return foundHome;
		
	}
	public void homeSearch(GeneralSpec spec) {
		foundHome=new ArrayList<>();
		Iterator <Home> homes=repository.iterator();
		while(homes.hasNext())
		{
			Home home=homes.next();
			if(spec.isSpecMatched(home) )
				foundHome.add(home);
		}
	}
	
	public List <Home> byPriceBetween(int area1,int area2)
	{
		spec=new ByPriceBetweenSpec( area1, area2);
		homeSearch(spec);
		return foundHome;
		
	}
	
	public List <Home> byPriceLess(int price)
	{
		spec=new ByPriceLessSpec(price);
		homeSearch(spec);
		return foundHome;
		
	}
	
	
	public List <Home> byAreaLess(int area)
	{
		spec=new ByAreaLessSpec(area);
		homeSearch(spec);
		return foundHome;
		
	}
	
	
		public List <Home> byBathrooms(int area)
		{
			spec=new byBathroomsSpec(area);
			homeSearch(spec);
			return foundHome;
			
		}
		
	
	public List <Home> byBedrooms(int bedrooms)
	{
		spec=new byBedroomsSpec(bedrooms);
		homeSearch(spec);
		return foundHome;
		
	}
	
	public List <Home> byPets(String pets)
	{
		spec=new byPetsSpec(pets);
		homeSearch(spec);
		return foundHome;
		
	}
	
	public List <Home> byLeaseLength(int lease)
	{
		spec=new byLeaseLengthSpec(lease);
		homeSearch(spec);
		return foundHome;
		
	}
	
}
