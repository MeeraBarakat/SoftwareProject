package mymain;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Multi {
	private Search searchhome;
	private List<Home> finalr=new CopyOnWriteArrayList<>();	
public Multi(List <Home> homes) {
	
	searchhome=new Search();
	searchhome.setrepository(homes);
	
	for(Home h:homes) {
	    			finalr.add(h);
	}
	
	}
public List<Home> cmp(GeneralSpec...multispec){
	for(GeneralSpec spec:multispec) {	
		List<Home>initial=searchhome.homeSearch(spec);
		 for( Home fhome:finalr) {	
			 boolean flag=false;
			 if(initial.contains(fhome)) {
					 flag=true;
				 }
			 if(!flag) {
				 finalr.remove(fhome); 
			 }	
		 }		 
	}

	
	return finalr;
}
}


