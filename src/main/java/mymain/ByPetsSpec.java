package mymain;

public class ByPetsSpec implements GeneralSpec {

		private String pets;

		public ByPetsSpec(String pets) {
			this.pets = pets;
		}



		public String getPets() {
			return pets;
		}


		public boolean isSpecMatched(Home home) {
			return home.getPets() .equals(getPets()) ;
		}


	}

