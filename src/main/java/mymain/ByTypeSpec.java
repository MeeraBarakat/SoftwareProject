package mymain;

public class ByTypeSpec implements GeneralSpec {

	private String type;

	public ByTypeSpec(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public boolean isSpecMatched(Home home) {
		return home.getType().equalsIgnoreCase(getType());
	}

}
