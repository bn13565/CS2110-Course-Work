import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


/***
 * This class contains the code to make a Village. Each Village is a node on a graph, and is a button 
 * that makes a popup with information about it. Each Village has an adjacency list, an array of roads, and 
 * and array of Gnomes.
 * 
 * @author Nikhil
 * 
 */

public class VillageNode extends JButton {
	
	int named; // each village is named from 1, 2, 3, ... incrementally
	Gnome[] gnomeArray;
	List<VillageNode> adjacencyList; // no need to make a custom linked list and die
	
	// getters and setters
	public int getNamed() {
		return this.named;
	}


	public void setName(int named) {
		this.named = named;
	}


	public Gnome[] getGnomeArray() {
		return gnomeArray;
	}


	public void setGnomeArray(Gnome[] gnomeArray) {
		this.gnomeArray = gnomeArray;
	}


	public List<VillageNode> getAdjacencyList() {
		return adjacencyList;
	}


	public void setAdjacencyList(List<VillageNode> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	
	// constructor
	public VillageNode(int named, List<VillageNode> adjacencyList, Gnome[] gnomeArray) {
		super();
		
		String name = Integer.toString(named);
		
		this.named = named;
		this.adjacencyList = adjacencyList;
		this.gnomeArray = gnomeArray;
		
		super.setText(name);
		
		// attach the onclick listener
		this.addActionListener(new VillageButtonActionListener());
				
	} // end of constructor
	
	
	/***
	 * Action-Listener class, easier just to embed it here rather than set the action listener for each individual button
	 * Handles the onclick event
	 * shows a kewl pop-up with some information
	 */
	
	class VillageButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			// show the popup
			VillageDetailsPopup popup = new VillageDetailsPopup((VillageNode) e.getSource());
			
			
			
			
		} // end of actionPerformed
		
	} // end of actionlistener class

	
	
}
