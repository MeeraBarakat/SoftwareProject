package mymain;

public class ByTypeSpec implements GeneralSpec {

	private String type;

	public ByTypeSpec(String type) {
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSpecMatched(Home home) {
		return home.getType().equalsIgnoreCase(getType());
	}

}
