package MainPackage;

public class Home {
	private String type;
	private String material;
	private String placement;
	private String pets;
	private String amenties;
	private int price;
	private int area;
	private int bedrooms;
	private int bathrooms;
	private int leaselength;
	
	public String getType() {
		return type;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String getPlacement() {
		return placement;
	}
	
	public String getPets() {
		return pets;
	}
	
	public String getAmenties() {
		return amenties;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getArea() {
		return area;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public int getBathrooms() {
		return bathrooms;
	}
	
	public int getLeaselength() {
		return leaselength;
	}
	
	public void setType(String t) {
		type=t;
	}
	
	public void setMaterial(String m) {
		material=m;
	}
	
	public void setPlacement(String p) {
		 placement=p;
	}
	
	public void setPets(String pt) {
		pets=pt;
	}
	
	public void setAmenties(String am) {
		amenties=am;
	}
	
	public void setPrice(int pr) {
		price=pr;
	}
	
	public void setArea(int a) {
		area=a;
	}
	
	public void setBedrooms(int br) {
		bedrooms=br;
	}
	
	public void setBathrooms(int bthr) {
		bathrooms=bthr;
	}
	
	public void setLeaselength(int ll) {
		leaselength=ll;
	}
	  public String toString() { 
return "\nType:"+type+"\nMaterial:"+material+"\nPacement:"+placement+"\nAllow Pets:"+pets+"\nAmenties:"+amenties+"\nPrice:"+price+"\nArea:"+area+"\nBedrooms:"+bedrooms+"\nBathrooms:"+bathrooms+"\nleaselenght:"+leaselength ;
	    } 
}
