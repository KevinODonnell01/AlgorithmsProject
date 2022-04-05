import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Objects;

public class busRouteFinder {

	public edgeWeightedGraph graph;
	public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int hashMapIndex = 0;
	
	//constuct all graphs
	busRouteFinder () {
		
		graph = VertexSize(); //no. of stops from stops.txt
		graph = EdgesTransfers(); //here
		graph = EdgesStopTimes();
	
	}

	
	public edgeWeightedGraph VertexSize() {
		String filename = "stops.txt";
		int countVerts = -1; //start on -1 because first line in file is not a stop
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				countVerts++;
				scanner.nextLine();
			}
			
			graph = new edgeWeightedGraph(countVerts);
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.print("no file");
			e.printStackTrace();
		}
		return graph;
	}
	
	public edgeWeightedGraph EdgesTransfers() {
		
		
		try {
			File file = new File("transfers.txt");
			Scanner scanner = new Scanner(file);
			String dud = scanner.nextLine();  // not used -- first line is not part of data
			while(scanner.hasNextLine()) {
				//breakdown of information
				String information = scanner.nextLine();
				String[] informationBreakdown = information.split(",");
				//stop1 into map
				int stop1 = Integer.parseInt(informationBreakdown[0]);
				if(map.get(stop1)==null) {
					map.put(stop1, hashMapIndex);
					hashMapIndex++;
				}
				//stop2 into map
				int stop2 = Integer.parseInt(informationBreakdown[1]);
				if(map.get(stop2)==null) {
					map.put(stop2, hashMapIndex);
					hashMapIndex++;
				}
				// get transfer type to obtain weight
				int transferType = Integer.parseInt(informationBreakdown[2]); 
				double cost =0;
				if(transferType==0) {
					cost = 2;	
				}
				
				else if(transferType==2) {
					double time = Double.parseDouble(informationBreakdown[3]);
					cost = time/100;
				}
				//create edge
				DirectedEdge edge = new DirectedEdge(map.get(stop1), map.get(stop2), cost); 
				//add to graph
				graph.addEdge(edge);
				//repeat till txt file finished 
			}
			scanner.close();	
		} catch (FileNotFoundException e) {
			System.out.print("no file found");
			e.printStackTrace();
		}
		
		return graph;
	}
	
	public edgeWeightedGraph EdgesStopTimes(){

		try {
			File file = new File("stop_times.txt");
			Scanner scanner = new Scanner(file);
			String dud = scanner.nextLine(); // not used -- first line is not part of data
			String information = scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String information2 =scanner.nextLine();
				//breakdown of information
	          
				String[] informationBreakdown = information.split(",");//current
				String[] informationBreakdown2 = information2.split(",");//next (current++)
				//make sure are on same route
				if(informationBreakdown[0] != informationBreakdown2[0]) {
					int stop1 = Integer.parseInt(informationBreakdown[3]);
					if(map.get(stop1)==null) {	// if bus stop not already encountered
						map.put(stop1, hashMapIndex);
						hashMapIndex++;
					}
				
				//stop2 into map
				int stop2 = Integer.parseInt(informationBreakdown2[3]);
				if(map.get(stop2)==null) {
					map.put(stop2, hashMapIndex);
					hashMapIndex++;
				}
				
				// get transfer type to obtain weight
				
				int cost =1;
				
				//ctreate edge
				DirectedEdge edge = new DirectedEdge(map.get(stop1), map.get(stop2), cost);
				//add to graph
				graph.addEdge(edge);
				//repeat till txt file finished 
				}
				information = information2;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.print("no file");
			e.printStackTrace();
		}
		return graph;
	}
	
	public static boolean findShortestPath(int firstStop, int secondStop) throws FileNotFoundException {
	
		busRouteFinder BRF = new busRouteFinder();
		    //index = mapped stop
			int stop1 = BRF.map.get(firstStop);
			int stop2 = BRF.map.get(secondStop);

			DijkstraSP dijkstraSP = new DijkstraSP(BRF.graph, stop1);
			
			if(dijkstraSP.hasPathTo(stop2)) {
				double pathLength = dijkstraSP.distTo(stop2);
				System.out.println("\nTotal trip cost:" + pathLength);
				
				Iterable<DirectedEdge> busRoute = dijkstraSP.pathTo(stop2);
				System.out.println("List of stops and associated costs en route to destiation");
				System.out.print("Stop IDs: \t Cost from last stop: \n");
			
				for(DirectedEdge s: busRoute) { //go through all directed edges in route
					System.out.println("" + s.to() + "\t\t\t " + s.weight() + "\n");
				}
				return true;
			}
			else {
				System.out.println("This trip is not possible, sorry.");
			}
			return false;
	
	}
}
