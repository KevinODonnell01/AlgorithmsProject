
import java.util.Arrays;

public class busStopFinder {
	public static final String[] STOP_KEYWORDS = new String[] { "FLAGSTOP", "WB", "NB", "SB", "EB" };

	public static String alterStringName(String stopName, boolean isSearch) {

		String[] stopWords = stopName.split(" ");

		while (Arrays.asList(STOP_KEYWORDS).contains(stopWords[0])) {
			String firstWord = stopWords[0];
			stopName = stopName.replace(firstWord, "").trim();
			stopName = stopName + " " + firstWord;
			stopWords = stopName.split(" ");
		}

		return stopName;
	}
}