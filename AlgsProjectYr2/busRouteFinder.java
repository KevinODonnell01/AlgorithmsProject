import java.util.HashMap;

public class busRouteFinder {

	public edgeWeightedGraph graph;
	public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int mapIndex = 0;
	
	busRouteFinder (String filename){
		graph = VertexSize(filename);
		graph = EdgesTransfers();
		graph = EdgesStopTimes();
	
	}

	
	public edgeWeightedGraph VertexSize(String filename) {
		return graph;
	}
	
	public edgeWeightedGraph EdgesTransfers() {
		return graph;
	}
	
	public edgeWeightedGraph EdgesStopTimes() {
		return graph;
	}
	
	public static boolean getShortestPath(int firstStop, int secondStop) {
		String filename = "stops.txt";
		busRouteFinder BRF = new busRouteFinder(filename);
		
		//next == ccreate graph edges, hashmap, dijkstra 
		return true;
	}
}
