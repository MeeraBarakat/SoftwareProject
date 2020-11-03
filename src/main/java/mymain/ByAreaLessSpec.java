package mymain;

public class ByAreaLessSpec implements GeneralSpec {

			private int area;

			public ByAreaLessSpec(int area) {
				this.area = area;
				// TODO Auto-generated constructor stub
			}

			public int getArea() {
				return area;
			}

			public boolean isSpecMatched(Home home) {
				return home.getArea() < getArea() ;
			}

		}

