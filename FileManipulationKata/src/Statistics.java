import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Statistics {

	/**
	 * @param args
	 */
	static ArrayList<String[]> people = new ArrayList<String[]>();
	public static void main(String[] args) throws FileNotFoundException {
		//We want to find most popular ice cream for ages>=45.
		//Find average age of JohnMcCallville
		//For those who are >=30 and love red, print names into file.
		Scanner scan = new Scanner(new File("output.txt"));
		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split(",");
			for (String s : line) {
				s = s.trim();
			}
			people.add(line);

		}
		ArrayList<String[]> people45Up = new ArrayList<String[]>();

		for(String[] person: people) {
			if(Integer.parseInt(person[1].trim()) >= 45) {
				people45Up.add(person);
			}
		}

		HashMap<String, Integer> flavorCount = new HashMap<String, Integer>();

		for(String[] person: people45Up) {
			if(!flavorCount.containsKey(person[3])) {
				flavorCount.put(person[3], 1);
			} else {
				flavorCount.put(person[3], flavorCount.get(person[3])+1);
			}
		}
		System.out.println(flavorCount.toString());
	}

}
