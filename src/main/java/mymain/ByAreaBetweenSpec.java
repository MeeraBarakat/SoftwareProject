package mymain;

public class ByAreaBetweenSpec implements GeneralSpec {

	private int area1;
	private int area2;

	public ByAreaBetweenSpec(int area1, int area2) {
		this.area1 = area1;
		this.area2 = area2;
	}

	

	public int getArea1() {
		return area1;
	}


	public int getArea2() {
		return area2;
	}


	public boolean isSpecMatched(Home home) {
		return home.getArea() < getArea2() && home.getArea() > getArea1();
	}

}
