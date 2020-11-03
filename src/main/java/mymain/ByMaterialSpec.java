package mymain;

public class ByMaterialSpec implements GeneralSpec {

	private String material;

	public ByMaterialSpec(String material) {
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public boolean isSpecMatched(Home home) {
		return home.getMaterial().equalsIgnoreCase(getMaterial());
	}

}
