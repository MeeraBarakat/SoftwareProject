package mymain;

public class ByPlacementSpec implements GeneralSpec {

	private String placement;

	public ByPlacementSpec(String placement) {
		this.placement = placement;
	}

	public String getPlacement() {
		return placement;
	}

	public boolean isSpecMatched(Home home) {
		return home.getPlacement().equalsIgnoreCase(getPlacement());
	}

}
