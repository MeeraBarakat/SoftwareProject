package mymain;

public class ByPriceBetweenSpec implements GeneralSpec {


		private int price1;
		private int price2;

		public ByPriceBetweenSpec(int price1, int price2) {
			this.price1 = price1;
			this.price2 = price2;
			// TODO Auto-generated constructor stub
		}

	
		public int getPrice1() {
			return price1;
		}


		public int getPrice2() {
			return price2;
		}

		public boolean isSpecMatched(Home home) {
			return home.getPrice() < getPrice2() && home.getPrice() > getPrice1();
		}

	}
