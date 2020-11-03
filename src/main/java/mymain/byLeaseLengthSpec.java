package mymain;

public class byLeaseLengthSpec implements GeneralSpec {

		private int Lease;

		public byLeaseLengthSpec(int Lease) {
			this.Lease = Lease;
			// TODO Auto-generated constructor stub
		}



		public int getLease() {
			return Lease;
		}



		public boolean isSpecMatched(Home home) {
			return home.getLeaselength() == getLease() ;
		}


	}

