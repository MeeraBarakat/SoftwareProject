package mymain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Search {
	List <Home> repository=new ArrayList<Home>();
	private ArrayList <Home> Found_home;
	ArrayList <Home> homes;
	ArrayList <Home> result=new ArrayList<>();
	public static final boolean PFLAG=false;
	
	
   public Search(ArrayList <Home> house){
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
		GeneralSpec spec=new ByPlacementSpec(placement);
		HomeSearch(spec);
		return Found_home ;
	}
	public List<Home> bymaterial(String material) {
		GeneralSpec spec=new ByMaterialSpec(material);
		HomeSearch(spec);
		return Found_home ;
	}
	public List<Home> bytype(String type) {
		GeneralSpec spec=new ByTypeSpec(type);
		HomeSearch(spec);
		return Found_home ;
	}
	public List<Home> byamenties(String amentie) {
		GeneralSpec spec=new ByAmentiesSpec(amentie);
		HomeSearch(spec);
		return Found_home ;
	}
	public List <Home> byAreaBetween(int area1,int area2)
	{
		GeneralSpec spec=new ByAreaBetweenSpec( area1, area2);
		HomeSearch(spec);
		return Found_home;
		
	}
	public void HomeSearch(GeneralSpec spec) {
		Found_home=new ArrayList<Home>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(spec.isSpecMatched(home) )
				Found_home.add(home);
		}
	}
	
	public List <Home> byPriceLess(int price)
	{
		Found_home=new ArrayList<Home>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getPrice() < price)
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	public List <Home> byPriceBetween(int price1,int price2)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getPrice() < price2 && home.getPrice() > price1)
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	public List <Home> byAreaLess(int area)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getArea() < area)
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	
	public List <Home> byBathrooms(int bathrooms)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getBathrooms()==bathrooms )
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	public List <Home> byBedrooms(int bedrooms)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getBedrooms()==bedrooms)
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	public List <Home> byPets(String Pets)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getPets().equalsIgnoreCase(Pets))
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
	public List <Home> byLeaseLength(int Lease)
	{
		Found_home=new ArrayList<>();
		Iterator <Home> Homes=repository.iterator();
		while(Homes.hasNext())
		{
			Home home=Homes.next();
			if(home.getLeaselength()==Lease)
				Found_home.add(home);
		}
		return Found_home;
		
	}
	
}
