package mymain;

public class ByAmentiesSpec implements GeneralSpec {

	private String amentie;

	public ByAmentiesSpec(String amentie) {
		this.amentie = amentie;
		// TODO Auto-generated constructor stub
	}

	public String getAmentie() {
		return amentie;
	}

	public void setAmentie(String amentie) {
		this.amentie = amentie;
	}

	public boolean isSpecMatched(Home home) {
		return home.getAmenties().contains(getAmentie());
	}

}
