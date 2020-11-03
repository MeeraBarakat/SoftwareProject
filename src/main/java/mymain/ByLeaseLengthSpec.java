package mymain;

public class ByLeaseLengthSpec implements GeneralSpec {

		private int lease;

		public ByLeaseLengthSpec(int lease) {
			this.lease = lease;
		}



		public int getLease() {
			return lease;
		}



		public boolean isSpecMatched(Home home) {
			return home.getLeaselength() == getLease() ;
		}


	}

