import java.util.ArrayList;
import java.util.List;


public class IdParser {

	public static List<Integer> parse(String string) {
		// Assume the string starts with '{' and ends with '} and is semicolon seperated.
		String substring = string.substring(1, string.length() - 1);
		String[] parts = substring.split(";");
		List<Integer> result = new ArrayList<Integer>();
		for (String s : parts) {
			if(s.length()>0){
				result.add(Integer.parseInt(s));
			}
		}
		return result;
	}

}
