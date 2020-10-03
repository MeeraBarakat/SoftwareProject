package MainPackage;

import java.util.ArrayList;




public class Search {

	enum Material {
		Stone,Brick,Wood
	}

	enum Amenities{
		AirConditioning, Balcony, Elevator, FirePlace, GarageParking,
		SwimmingPool
	}

	enum type {
		Apartment, house
	}

	enum Placement {
		City, Village
	}

	enum LeaseLength {
		shortterm_6months, longterm_year
	}
	
	enum Pets {
		Yes,No
	}
	ArrayList <Home> Homes;
	ArrayList <Home> Result=new ArrayList<Home>();
   public Search(ArrayList <Home> H){
		Homes=H;
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
	public ArrayList <Home> iSearchAboutHomeWithString(	ArrayList <String> S) {
		
		Result.clear();
			boolean flag=true;
			String typ = null;
			String mater=null;
			String place=null;
			String ami=null;
			String pet=null;
			int bed=0;
			int bath=0;
			int ll=0;
			int p=0;
			int area=0;
			int area1=0;
			int area2=0;
			int price1=0;
			int price2=0;
				for(String s: S)
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
				  p=Integer.parseInt(num[0]);
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
				
				for(Home h:Homes)
				{
					flag=true;
					if(typ != null)
						if(! (h.getType().equalsIgnoreCase(typ)))
							{
							flag=false;
							}
					if(mater != null)
						if(!( h.getMaterial().equalsIgnoreCase(mater)))
							{
							flag=false;
							}
					if(place != null)
						if(! (h.getPlacement().equalsIgnoreCase(place)))
							{
							flag=false;
							}
					if(ami != null)
						if((! h.getAmenties().toUpperCase().contains(ami.toUpperCase())))
							{
							flag=false;
							
							}
					if(pet != null)
						if(! (h.getPets().equalsIgnoreCase(pet)))
							{
							flag=false;
							}
					if(bed!=0)
						if(! (h.getBedrooms()==bed)) {
							flag=false;
						}
					if(bath!=0)
						if(! (h.getBathrooms()==bath)) {
							flag=false;
						}
					if(ll!=0)
						if(! (h.getLeaselength()==ll)) {
							flag=false;
						}
					if(p!=0)
						if(! (h.getPrice()<p)) {
							flag=false;
						}
					if(area!=0)
						if(! (h.getArea()<area)) {
							flag=false;
						}
					if(area1 !=0)
						if(! (h.getArea()<area2 && h.getArea()>area1)) {
							flag=false;
						}
					
					if(price1 !=0)
						if(! (h.getPrice()<price2 && h.getPrice()>price1)) {
							flag=false;
						} 
					if(flag == true) {
						
						Result.add(h);
						
					}
				}
			return Result;	
		}
	

}
