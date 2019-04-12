package unit04.util;

public class ParseUtil {
	public static int parseInt(String value) {
		return parseInt(value, 1);
	}
	static int parseInt(String value, int def) {
		int number = def;
		if(value != null) {
			try {
				number = Integer.parseInt(value);
			}catch(Exception e) {}
		}
		return number;
	}
}
