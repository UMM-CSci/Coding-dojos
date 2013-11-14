import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Statistics {

	/**
	 * @param args
	 */
	static ArrayList<Person> people = new ArrayList<Person>();
	static FileWriter writer;
	
	public static void main(String[] args) throws IOException {
		//We want to find most popular ice cream for ages>=45. DONE
		//Find average age of JohnMcCallville
		//For those who are >=30 and love red, print names into file.
		ArrayList<String[]> rawPerson = new ArrayList<String[]>();
		Scanner scan = new Scanner(new File("output.txt"));
		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split(",");
			for (String s : line) {
				s = s.trim();
			}
			rawPerson.add(line);
		}
		for (String[] strings : rawPerson) {
			people.add(new Person(strings));
		}
		
		HashMap<String, Integer> icecreams = new HashMap<String, Integer>();
		
		for (Person person : people) {
			if (person.getAge() >= 45) {
				if (icecreams.containsKey(person.getIceCream())) {
					icecreams.put(person.getIceCream(), icecreams.get(person.getIceCream()) + 1);
				}
				else {
					icecreams.put(person.getIceCream(), 1);
				}
			}
		}
		System.out.println(icecreams.toString());
		System.out.println(findMax(icecreams));
		
		ArrayList<Integer> ages = new ArrayList<Integer>();
		for (Person person : people) {
			if(person.getCity().equals("JohnMcCallville")){
				ages.add(person.getAge());
			}
		}
		System.out.println(ages.toString());
		System.out.println(average(ages));
		ArrayList<String> hitlist = new ArrayList<String>();
		for (Person person : people) {
			if(person.getAge()>=30 && person.getColor().equals("Red")){
				hitlist.add(person.getName());
			}
		}
		System.out.println(hitlist.toString());
		for (String string : hitlist) {
			writeLine(string + "\n");
			
		}
		writer.flush();
	}

	public static String findMax(HashMap<String, Integer> hash) {
		String currentFav = null;
		for (String icecream : hash.keySet()) {
			if (currentFav == null) {
				currentFav = icecream;
			} else {
				if (hash.get(currentFav) < hash.get(icecream)) {
					currentFav = icecream;
				}
			}
		}
		return currentFav;
	}
	
	public static double average(ArrayList<Integer> ages){
		Integer ageSum = 0;
		for (Integer integer : ages) {
			ageSum+=integer;
		}
		
		Double agesDouble = Double.parseDouble(ageSum.toString());
		Double meanAges = agesDouble/ages.size();
		return meanAges;
	}
	
	public static void writeLine(String line) throws IOException{
		if(writer == null){
			File file = new File("oldPeopleLovingRed.txt");
			writer = new FileWriter(file);
			writer.write(" ");
			writer = new FileWriter(file, true);
		}
		System.out.println("blah");
		writer.write(line);
	}
}
