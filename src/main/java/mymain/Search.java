package mymain;

import java.util.ArrayList;




public class Search {

	enum Material {
		STONE,BRICK,WOOD
	}

	enum Amenities{
		AIRCONDITIONING, BALCONY, ELEVATOR, FIREPLACE,GARAGEPARKING,
		SWIMMINGPOOL
	}

	enum type {
		APARTMENT, HOUSE
	}

	enum Placement {
		CITY,VILLAGE
	}

	enum LeaseLength {
		SHORTTERM_6MONTHS,LONGTERM_YEAR
	}
	
	enum Pets {
		YES,NO
	}
	ArrayList <Home> homes;
	ArrayList <Home> result=new ArrayList<>();
	public static final boolean PFLAG=false;
   public Search(ArrayList <Home> house){
		homes=house;
	}
	public void printRes(ArrayList <Home> myResult) {
		String res;
		for(Home h:myResult)
		{
			res="Home" + "[" +"type:"+h.getType()+","+"Material:"+h.getMaterial()+","+"Placement:"+h.getPlacement()+"\n"+","+"Allow Pets:"+h.getPets()+","+"Amenties:"+h.getAmenties()+","+"\n"+"Price:"+h.getPrice()+","+"Area:"+h.getArea()+","+"Bedrooms:"+h.getBedrooms()+","+"\n"+"Bathrooms:"+h.getBathrooms()+","+"leaselenght:"+h.getLeaselength()+"]";
			System.out.println(res);
			System.out.println();
		}
		
	}
	public ArrayList <Home> searchStrings(	ArrayList <String> sHome) {
		
		result.clear();
			boolean flag=true;
			String typ = null;
			String mater=null;
			String place=null;
			String ami=null;
			String pet=null;
			int bed=0;
			int bath=0;
			int ll=0;
			int pri=0;
			int area=0;
			int area1=0;
			int area2=0;
			int price1=0;
			int price2=0;
				for(String s: sHome)
				{
			String []num=s.split(" ");
			if(num.length==2) {
			  if(num[1].equalsIgnoreCase("bedroom"))
				  bed=Integer.parseInt(num[0]);
			  else if(num[1].equalsIgnoreCase("bathroom"))
				  bath=Integer.parseInt(num[0]);
			  else if(num[1].equalsIgnoreCase("area"))
				   area=Integer.parseInt(num[0]);
			  else if(num[1].equalsIgnoreCase("price"))
				  pri=Integer.parseInt(num[0]);
			  else if(num[1].equalsIgnoreCase("LeaseLength"))
				  ll=Integer.parseInt(num[0]);
			  
			}
			else if(num.length==3) {
				
				if(num[0].equalsIgnoreCase("priceBetween"))
					  {price1=Integer.parseInt(num[1]);
					  price2=Integer.parseInt(num[2]);
					  }
				else if(num[0].equalsIgnoreCase("areaBetween"))
					{area1=Integer.parseInt(num[1]);
				  area2=Integer.parseInt(num[2]);}
			}
			  else {	
					for(type m:type.values())
						if(s.equalsIgnoreCase(m.toString()))
					      typ=m.toString();
					
				 for(Material m:Material.values())
						if(s.equalsIgnoreCase(m.toString()))
					      mater=m.toString();
					
					for(Placement m:Placement.values())
						if(s.equalsIgnoreCase(m.toString()))
					      place=m.toString();
					
					for(Amenities m:Amenities.values())
						if(s.equalsIgnoreCase(m.toString()))
					       ami=m.toString();
					
					for(Pets m:Pets.values())
						if(s.equalsIgnoreCase(m.toString()))
					       pet=m.toString();
			  }
				}
				
				for(Home h:homes)
				{
					flag=true;
					if(typ != null && !(h.getType().equalsIgnoreCase(typ)))
							flag=false;
					if(mater != null && !( h.getMaterial().equalsIgnoreCase(mater)))
							flag=false;
					if(place != null && ! (h.getPlacement().equalsIgnoreCase(place)))
							flag=false;
					if(ami != null && ! (h.getAmenties().toUpperCase().contains(ami.toUpperCase())))
							flag=false;		
					if(pet != null && ! (h.getPets().equalsIgnoreCase(pet)))
							flag=false;
					if(bed!=0 &&h.getBedrooms()!=bed)
							flag=false;
					if(bath!=0 && h.getBathrooms()!=bath)
							flag=false;
					if(ll!=0 && h.getLeaselength()!=ll)
							flag=false;
					if(pri!=0 && h.getPrice()>=pri)
							flag=false;
					if(area!=0 && h.getArea()>=area)
							flag=false;
					if(area1 !=0 && ! (h.getArea()<area2 && h.getArea()>area1))
							flag=false;
					if(price1 !=0 && ! (h.getPrice()<price2 && h.getPrice()>price1))
							flag=false;
					if(flag) {
						
						result.add(h);
						
					}
				}
			return result;	
		}
	

}
