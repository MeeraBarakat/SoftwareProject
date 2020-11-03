package mymain;

public class byBathroomsSpec implements GeneralSpec {
				private int bathrooms;

				public byBathroomsSpec(int bathrooms) {
					this.bathrooms = bathrooms;
					// TODO Auto-generated constructor stub
				}



				public int getBathrooms() {
					return bathrooms;
				}


				public boolean isSpecMatched(Home home) {
					return home.getBathrooms() == getBathrooms() ;
				}

			}

