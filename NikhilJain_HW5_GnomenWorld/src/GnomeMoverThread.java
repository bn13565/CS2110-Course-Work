import java.util.ArrayList;
import java.util.List;

/***
 * 
 * 
 * Moves gnomes around to adjacent villages on their own thread
 * 
 * @author Nick
 *
 */
public class GnomeMoverThread extends Thread {
	
//	Gnome gnome;
	VillageNode village;
	List<VillageNode> adjacentVillages;
	List<Gnome> currentVillageGnomes; // current village's gnomes that the gnome is in
	VillageDetailsPopup startDestination;
	
	public GnomeMoverThread(VillageNode village) {
		
		this.village = village;
		adjacentVillages = village.getAdjacencyList();
		currentVillageGnomes = village.getGnomeArray();
		
		startDestination = village.villageDetailsPopup;
		
	} // end of constructor
	
	
	@Override
	public void run() {
		
		// randomly pick a village to go to
		/***
		 * testing village movement
		 */
		////finnafinaifnainfainfianfienfiawiahihatethisfinaifnainfaifaifaififinfinfiafianfaifianfinifna
		
		
		// Nikhil's 3 step plan for success
		// 1. store all the village's gnomes
		// 2. remove all gnomes in one shot
		// 3. move the gnomes to a new spot
		// 4. ???
		// 5. profit
		
		// step 1
		List<Gnome> storeNames = new ArrayList<Gnome>();
		
		for (Gnome g : village.getGnomeArray()) 
			storeNames.add(g);
		
		// step 2
		village.getGnomeArray().removeAll(village.getGnomeArray());
//		System.out.println("GNOME ARRAY LENGTH: " + village.getGnomeArray().size());
		
		// step 3
		for (Gnome g : village.getGnomeArray()) {
			
			// access the randomly chosen village
			VillageNode newVillage = village.getAdjacencyList().get(getNewVillageChoice());
			
			// add the new gnome
			newVillage.getGnomeArray().add(g);
			
		}
		
		
		
		/***
		 * Update UI here
		 */
		startDestination.updateGnomeDisplay();
		
	} // end of run
	
	private int getNewVillageChoice() {
	
		// look at adjacency list
		// randomply pick one of the villages
		// move gnome to said village
		
		List<Integer> villageRandomizer = new ArrayList<Integer>(); 
		
		for (VillageNode v : adjacentVillages) {
			
			villageRandomizer.add(v.getNamed());
			
		} // end of for
		
		
		// pick
		int choice = (int) (villageRandomizer.size() * Math.random());
		
		/***
		 * TESTING STUFF
		 */
		
//		for (int x : villageRandomizer) {
//			System.out.println("Content of villageRandomizer " + x);
//		}
		
		System.out.println("Chosen new village: " + choice);
		
		return choice;
	}
	
	

} // end of class
