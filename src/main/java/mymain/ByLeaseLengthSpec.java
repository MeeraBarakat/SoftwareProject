package mymain;

public class ByLeaseLengthSpec implements GeneralSpec {

		private int Lease;

		public ByLeaseLengthSpec(int Lease) {
			this.Lease = Lease;
		}



		public int getLease() {
			return Lease;
		}



		public boolean isSpecMatched(Home home) {
			return home.getLeaselength() == getLease() ;
		}


	}

