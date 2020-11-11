package mymain;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Search {
	List <Home> repository=new ArrayList<>();
	List <Home> homes;
	ArrayList <Home> result=new ArrayList<>();
	GeneralSpec spec;

	public static final boolean PFLAG=false;
	 OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
	 public Search(List <Home> house){
		homes=house;
		repository=house;
	}
   
   
	public void printRes(List <Home> myResult) throws IOException {
		String res;
		for(Home h:myResult)
		{
			res="Home" + "[" +"type:"+h.getType()+","+"Material:"+h.getMaterial()+","+"Placement:"+h.getPlacement()+"\n"+","+"Allow Pets:"+h.getPets()+","+"Amenties:"+h.getAmenties()+","+"\n"+"Price:"+h.getPrice()+","+"Area:"+h.getArea()+","+"Bedrooms:"+h.getBedrooms()+","+"\n"+"Bathrooms:"+h.getBathrooms()+","+"leaselenght:"+h.getLeaselength()+"]";
			streamWriter.write(res);
		     streamWriter.flush();
		     streamWriter.write("\n");
		     streamWriter.flush();
		}
		
	}
	public List<Home> byplacement(String placement) {
		spec=new ByPlacementSpec(placement);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	public List<Home> bymaterial(String material) {
		spec=new ByMaterialSpec(material);
		homeSearch(spec);
		return homeSearch(spec);
	}
	public List<Home> bytype(String type) {
		spec=new ByTypeSpec(type);
		homeSearch(spec);
		return homeSearch(spec);
	}
	public List<Home> byamenties(String amentie) {
		spec=new ByAmentiesSpec(amentie);
		homeSearch(spec);
		return homeSearch(spec);
	}
	public List <Home> byAreaBetween(int area1,int area2)
	{
		spec=new ByAreaBetweenSpec( area1, area2);
		homeSearch(spec);
		return homeSearch(spec);
		
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
	
	public List <Home> byPriceBetween(int area1,int area2)
	{
		spec=new ByPriceBetweenSpec( area1, area2);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	
	public List <Home> byPriceLess(int price)
	{
		spec=new ByPriceLessSpec(price);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	
	
	public List <Home> byAreaLess(int area)
	{
		spec=new ByAreaLessSpec(area);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	
	
		public List <Home> byBathrooms(int bathrooms)
		{
			spec=new ByBathroomsSpec(bathrooms);
			homeSearch(spec);
			return homeSearch(spec);
			
		}
		
	
	public List <Home> byBedrooms(int bedrooms)
	{
		spec=new ByBedroomsSpec(bedrooms);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	
	public List <Home> byPets(String pets)
	{
		spec=new ByPetsSpec(pets);
		homeSearch(spec);
		return homeSearch(spec);
		
	}
	
	public List <Home> byLeaseLength(int lease)
	{
		spec=new ByLeaseLengthSpec(lease);
		homeSearch(spec);
		return homeSearch(spec);
		
	}



	
}
