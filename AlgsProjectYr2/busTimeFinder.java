import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class busTimeFinder {

	public static ArrayList<stopDetails> arrDetails;// create array of all matching times

	public static boolean findArrivalTime(String timeSearched) throws FileNotFoundException {

		arrDetails = new ArrayList<>();
		File file = new File("stop_times.txt");
		Scanner scanner = new Scanner(file);
		String dud = scanner.nextLine();
		while (scanner.hasNextLine()) {
			String information2 = scanner.nextLine();
			// breakdown of information
			String[] informationBreakdown2 = information2.split(",");
			String informationBreakdown3 = informationBreakdown2[1].trim();

			if (informationBreakdown3.equals(timeSearched)) {
				arrDetails.add(
						new stopDetails(informationBreakdown2[1], informationBreakdown2[3], informationBreakdown2[0]));
			}

		}
//quicksort

		for (int i = 0; i < arrDetails.size(); i++) {
			System.out.println("----------------------------------------------------------------------\n");
			System.out.println("Trip Route:" + arrDetails.get(i).route + "\n" + "Stop Number:" + arrDetails.get(i).stop
					+ "\n" + "Arrival Time:" + arrDetails.get(i).time + "\n");
		}
		return true;
	}
}
