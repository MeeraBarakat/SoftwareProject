package mymain;

public class ByPriceLessSpec implements GeneralSpec {


		private int price;

		public ByPriceLessSpec(int price) {
			this.price = price;
		}

		public int getPrice() {
			return price;
		}

		public boolean isSpecMatched(Home home) {
			return home.getPrice() < getPrice() ;
		}

	}
