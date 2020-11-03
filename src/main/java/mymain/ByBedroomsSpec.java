package mymain;

public class ByBedroomsSpec implements GeneralSpec {
	private int bedrooms;

	public ByBedroomsSpec(int bedrooms) {
		this.bedrooms = bedrooms;
	}


	public int getbedrooms() {
		return bedrooms;
	}


	public boolean isSpecMatched(Home home) {
		return home.getBedrooms() == getbedrooms() ;
	}


}
