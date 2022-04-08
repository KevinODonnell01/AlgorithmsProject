
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {

	public static void main(String[] args) throws FileNotFoundException {

		boolean run = false;
		do {
			run = UI();
		} while (run);
	}

	// ui
	public static boolean UI() throws FileNotFoundException {
		// TODO Auto-generated method stub
		boolean quit = false;
		Scanner scanner = new Scanner(System.in);
		// UI
		while (quit == false) {
			System.out.print("Please select an option for our bus route searching system below \n"
					+ "1 - Find shortest paths between 2 bus stops \n"
					+ "2 - Search for a bus stop by full name or by the first few characters in the name \n"
					+ "3 - Searching for all trips with a given arrival time \n" + "4 - to quit the search engine\n");

			int choice = scanner.nextInt();

			if (choice == 4) {
				quit = true;
				System.out.print("You have quit the search engine, goodbye \n ");
				System.exit(0);
				return false;
			}

			else if (choice == 1 || choice == 2 || choice == 3) {
				System.out.print("You have chosen option " + choice + "\n");

				if (choice == 1) {
					int firstStop = 0, secondStop = 0;
					boolean validFirst = false;
					boolean validSecond = false;
					boolean different = false;

					do {

						while (validFirst == false) {
							System.out.print("Please enter the first (starting) stop in your trip: \n");
							if (scanner.hasNextInt()) {
								firstStop = scanner.nextInt();
								validFirst = true;
							} else {
								System.out.print("That was not an integer, Please retry \n");

							}
							// check if valid
						}
						// now get second stop

						while (validSecond == false) {
							System.out.print("Plaese enter the second(destination) stop in your trip \n");
							if (scanner.hasNextInt()) {
								secondStop = scanner.nextInt();
								validSecond = true;
							} else {
								System.out.print("That was not an integer, please retry \n");

							}
							// check if valid
						}

						// check if stops are different
						if (firstStop == secondStop) {
							System.out.print("Your stops were the same hense there is no shorest path, please re-do\n");
							different = false;
							validFirst = false;
							validSecond = false;
						} else {
							different = true;
						}
					} while (different == false);
					// both valid

					try {

						busRouteFinder.findShortestPath(firstStop, secondStop);
					} catch (FileNotFoundException e) {
						System.out.print("nope");
					}
				}

				if (choice == 2) {
					System.out.print(
							"Please type the name of the stop you are searching for, or even just the first few letters:");
					String stopName;
					stopName = scanner.next();
					stopName = stopName.trim().toUpperCase();
					String filename = "stops.txt";
					TST tst = new TST(filename);
					for (String x : tst.getStopInformation(stopName)) {
						System.out.println(x);
					}
				}

				if (choice == 3) {
					System.out.print("Please search for an arrival time in the format of a 24hr clock (xx:yy:zz) :");

					String arrivalTime = scanner.next();
					if (arrivalTime.charAt(0) == 0) { // if inputed as 05:30:19
						arrivalTime = arrivalTime.substring(1);
						System.out.print(arrivalTime);
					}
					if (timeFormatChecker(arrivalTime)) { // check first if format is correct

						busTimeFinder.findArrivalTime(arrivalTime);
					} else {
						System.out.println("You must enter a valid time in the format  - hh:mm:ss");
					}
				}

			} else {
				System.out.print("please pick a valid option \n");

			}
		}
		return true;

	}

	private static boolean timeFormatChecker(String timeSearched) {
		// https://www.geeksforgeeks.org/how-to-validate-time-in-24-hour-format-using-regular-expression/
		String regex = "(([0-9]:[0-5][0-9]:[0-5][0-9])|([2][0-3]:[0-5][0-9]:[0-5][0-9])|([0-1][0-9]:[0-5][0-9]:[0-5][0-9]))";
		Pattern p = Pattern.compile(regex);
		if (timeSearched == null) {
			return false;
		}
		Matcher m = p.matcher(timeSearched);
		return m.matches();
	}

	// original checker didnt work
	// because can be 7 or 8 chars
	/*
	 * int checkerCount =0; String x0 = String.valueOf(timeSearched.charAt(0));
	 * String x1 = String.valueOf(timeSearched.charAt(1)); String x2 =
	 * String.valueOf(timeSearched.charAt(2)); String x3 =
	 * String.valueOf(timeSearched.charAt(3)); String x4 =
	 * String.valueOf(timeSearched.charAt(4)); String x5 =
	 * String.valueOf(timeSearched.charAt(5)); String x6 =
	 * String.valueOf(timeSearched.charAt(6)); String x7 =
	 * String.valueOf(timeSearched.charAt(7));
	 * 
	 * 
	 * if (x0 == ""||x0 == " " || x0 =="0" || x0 =="1" || x0 =="2" || x0 =="3" || x0
	 * =="4" || x0 =="5" || x0 =="6" || x0 =="7" || x0 =="8" || x0 =="9" ) {
	 * checkerCount++; System.out.print("1"); } if (x1 =="0" || x1 =="1" || x1 =="2"
	 * || x1 =="3" || x1 =="4" || x1 =="5" || x1 =="6" || x1 =="7" || x1 =="8" || x1
	 * =="9" ) { checkerCount++; System.out.print("1"); } if (x2 ==":") {
	 * checkerCount++; System.out.print("1"); } if (x3 =="0" || x3 =="1" || x3 =="2"
	 * || x3 =="3" || x3=="4" || x3 =="5" || x3 =="6" || x3 =="7" || x3 =="8" || x3
	 * =="9" ) { checkerCount++; System.out.print("1"); }if (x4 =="0" || x4 =="1" ||
	 * x4=="2" || x4 =="3" || x4 =="4" || x4 =="5" || x4 =="6" || x4 =="7" || x4
	 * =="8" || x4 =="9" ) { checkerCount++; System.out.print("1"); } if (x5 ==":")
	 * { checkerCount++; System.out.print("1"); } if (x6 =="0" || x6 =="1" || x6
	 * =="2" || x6 =="3" || x6=="4" || x6 =="5" || x6 =="6" || x6 =="7" || x6 =="8"
	 * || x6 =="9" ) { checkerCount++; System.out.print("1"); }if (x7 =="0" || x7
	 * =="1" || x7=="2" || x7 =="3" || x7 =="4" || x7 =="5" || x7 =="6" || x7 =="7"
	 * || x7 =="8" || x7 =="9" ) { checkerCount++; System.out.print("1"); }
	 * 
	 * if(checkerCount == 8) { System.out.print("1"); return true; }
	 * 
	 * return false;
	 * 
	 * }
	 */
}
