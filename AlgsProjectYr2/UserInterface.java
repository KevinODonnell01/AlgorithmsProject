
public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean quit = false; 
		int count = 0;
		while(quit==false) {
			System.out.print("Please select an option for our bus route searching system below \n"
					+ "1 - Find shortest paths between 2 bus stops \n"
					+ "2 - Search for a bus stop by full name or by the first few characters in the name \n"
					+ "3 - Searching for all trips with a given arrival time");
			count++;
			if(count==2) {
				quit = true;
			}
		}
	}

}
