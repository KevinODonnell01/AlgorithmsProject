import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class busRouteFinder {

	public edgeWeightedGraph graph;
	public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int mapIndex = 0;
	
	busRouteFinder (String filename) throws FileNotFoundException{
		graph = VertexSize(filename); //no. of stops from stops.txt
		graph = EdgesTransfers();
		graph = EdgesStopTimes();
	
	}

	
	public edgeWeightedGraph VertexSize(String filename) throws FileNotFoundException {
		int countVerts = -1; //start on -1 because first line in file is not a stop
		File file = new File(filename);
		
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			countVerts++;
		}
		graph = new edgeWeightedGraph(countVerts);
		return graph;
	}
	
	public edgeWeightedGraph EdgesTransfers() {
		return graph;
	}
	
	public edgeWeightedGraph EdgesStopTimes() {
		return graph;
	}
	
	public static boolean getShortestPath(int firstStop, int secondStop) throws FileNotFoundException {
		String filename = "stops.txt";
		busRouteFinder BRF = new busRouteFinder(filename);

		return true;
	}
}
