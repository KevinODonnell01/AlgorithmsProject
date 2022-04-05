import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class busStopFinder {

	TST<String[]> TST;
    // name in index 2
	
	
	
	
	busStopFinder(){
		TST = new TST<String[]>();
		// create tst from file
		String filename = "stops.txt";
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			String dud = scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String information = scanner.nextLine();
				String[] informationBreakdown = information.split(",");
				String stop =  informationBreakdown[2];
		
				
				String alteredStop = changeNameOf(stop);
				TST.put(alteredStop, informationBreakdown);
			}
		} catch (FileNotFoundException e) {
			System.out.print("file not found");
			e.printStackTrace();
		}

		
	}
	
	
	public static String changeNameOf(String stopName) {
		String[] stopWordBreakdown = stopName.split(" ");
		String alteredStop;
	        if (stopWordBreakdown[0] == "WB" || stopWordBreakdown[0] == "wb") {

	        	int s = stopWordBreakdown.length;
	        	stopWordBreakdown[s+1] = "WB";
	        	StringBuffer sb = new StringBuffer();
	            for(int i = 1; i < stopWordBreakdown.length; i++) {
	               sb.append(stopWordBreakdown[i]);
	            }
	             alteredStop = sb.toString();
	            
	        } else if (stopWordBreakdown[0] == "NB" || stopWordBreakdown[0] == "nb") {
	        	
	        	int s = stopWordBreakdown.length;
	        	stopWordBreakdown[s+1] = "NB";
	        	StringBuffer sb = new StringBuffer();
	            for(int i = 1; i < stopWordBreakdown.length; i++) {
	               sb.append(stopWordBreakdown[i]);
	            }
	             alteredStop = sb.toString();
	        	
	        } else if (stopWordBreakdown[0] == "SB" || stopWordBreakdown[0] == "sb") {
	        	
	        	int s = stopWordBreakdown.length;
	        	stopWordBreakdown[s+1] = "NB";
	        	StringBuffer sb = new StringBuffer();
	            for(int i = 1; i < stopWordBreakdown.length; i++) {
	               sb.append(stopWordBreakdown[i]);
	            }
	             alteredStop = sb.toString();
	        	
	        } else if (stopWordBreakdown[0] == "EB" || stopWordBreakdown[0] == "eb") {
	        	
	        	int s = stopWordBreakdown.length;
	        	stopWordBreakdown[s+1] = "NB";
	        	StringBuffer sb = new StringBuffer();
	            for(int i = 1; i < stopWordBreakdown.length; i++) {
	               sb.append(stopWordBreakdown[i]);
	            }
	             alteredStop = sb.toString();
	             
	        } 
	        else if (stopWordBreakdown[0] == "FLAGSTOP" || stopWordBreakdown[0] == "flagstop") {
	        	
	        	int s = stopWordBreakdown.length;
	        	stopWordBreakdown[s+1] = "FLAGSTOP";
	        	StringBuffer sb = new StringBuffer();
	            for(int i = 1; i < stopWordBreakdown.length; i++) {
	               sb.append(stopWordBreakdown[i]);
	            }
	             alteredStop = sb.toString();
	             
	        } else {
	            alteredStop = stopName;
	        }
	        
		return alteredStop;
	}
	


	public static boolean findStop(String stopName){
	    return true;
	}
	

}
