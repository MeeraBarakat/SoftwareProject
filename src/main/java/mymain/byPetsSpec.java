package mymain;

public class byPetsSpec implements GeneralSpec {

		private String Pets;

		public byPetsSpec(String Pets) {
			this.Pets = Pets;
		}



		public String getPets() {
			return Pets;
		}


		public boolean isSpecMatched(Home home) {
			return home.getPets() .equals(getPets()) ;
		}


	}

