package mymain;

public class ByBathroomsSpec implements GeneralSpec {
				private int bathrooms;

				public ByBathroomsSpec(int bathrooms) {
					this.bathrooms = bathrooms;
				}



				public int getBathrooms() {
					return bathrooms;
				}


				public boolean isSpecMatched(Home home) {
					return home.getBathrooms() == getBathrooms() ;
				}

			}

