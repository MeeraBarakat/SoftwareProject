package mymain;

public class byBedroomsSpec implements GeneralSpec {
	private int bedrooms;

	public byBedroomsSpec(int bedrooms) {
		this.bedrooms = bedrooms;
	}


	public int getbedrooms() {
		return bedrooms;
	}


	public boolean isSpecMatched(Home home) {
		return home.getBedrooms() == getbedrooms() ;
	}


}
