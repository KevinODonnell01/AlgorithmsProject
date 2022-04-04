import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		
		boolean run = false;
		do {
            run = UI();
        } while (run);
	}
	
	//methods
	  private static void getShortestPath(int stop1, int stop2) {
	     System.out.print("stop 1 " + stop1 + "stop 2 " +stop2);
	    }
	
	//ui
	public static boolean UI () {
	// TODO Auto-generated method stub
			boolean quit = false; 
			Scanner scanner= new Scanner(System.in);
			//UI
			while(quit==false) {
				System.out.print("Please select an option for our bus route searching system below \n"
						+ "1 - Find shortest paths between 2 bus stops \n"
						+ "2 - Search for a bus stop by full name or by the first few characters in the name \n"
						+ "3 - Searching for all trips with a given arrival time \n"
						+ "4 - to quit the search engine");
			
				
				int choice = scanner.nextInt();
				boolean valid = false;
				try {
					valid = true;
					return false;
				}  catch (NumberFormatException e) {

		        }
				
				if(choice == 4) {
					quit = true;
					System.out.print("You have quit the search engine, goodbye \n ");
					return false;
					}
				
				else if( choice == 1 || choice == 2 || choice ==3) {
					System.out.print("You have chosen an option \n");
					
					if(choice == 1) {
						int firstStop =0 , secondStop =0;
						boolean validFirst = false;
						boolean validSecond = false;
						boolean different = false;
						
						do{
							
						while(validFirst == false) {
						System.out.print("Plaese enter the first stop in your trip \n");
						if(scanner.hasNextInt()) {
								firstStop = scanner.nextInt();
								validFirst = true;
						}
						else{
							System.out.print("That was not an integer, Please retry \n");
							
						}
						//check if valid
						}
						// now get second stop
						
						while(validSecond == false) {
						System.out.print("Plaese enter the second stop (destination) in your trip \n");
						if(scanner.hasNextInt()) {
							secondStop = scanner.nextInt();
							validSecond = true;
						}
						else{
							System.out.print("That was not an integer, please retry \n");
							
						}
						// check if valid
						}
						
						// check if stops are different
						if(firstStop == secondStop) {
							System.out.print("Your stops were the same hense there is no shorest path, please re-do\n");
							different = false;
							validFirst = false;
							validSecond = false;
						}
						else{
							different = true;
						}
						}while(different == false) ;
						// both valid
				 busRouteFinder.getShortestPath(firstStop, secondStop);
					}
					
					if (choice == 2) {
						
					}
					
					if (choice == 3) {
						
					}
					
					
				}
				else {
					System.out.print("please pick a valid option \n");
				}
			}
		return true;
	}
}

