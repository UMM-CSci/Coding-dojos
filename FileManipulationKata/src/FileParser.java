import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileParser {
	Scanner sc;
	FileWriter writer;
	String[] iceCreams = {"Vanilla", "Chocolate", "Strawberry", "Rocky-Road", "Cookie-dough"};
	ArrayList<String> iceCreamz = new ArrayList<String>(Arrays.asList(iceCreams));
	
	public String readLine() throws FileNotFoundException {
		String toReturn;
		
		if(sc == null) {
			 sc = new Scanner(new File("src/data.txt"));
		}
		
		if(sc.hasNext()) {
			toReturn =  sc.nextLine();
		} else {
			toReturn = "";
		}
		System.out.println(toReturn);
		return toReturn;
	}
	
	public void parseFile() throws IOException{
		String line = readLine();
		while(!line.equals("")) {
			parseLine(line);
			line = readLine();
		}
		
		writer.flush();
	}
	
	public void parseLine(String line) throws IOException {
		String[] stringArr = line.split(",");
		String name = "";
		String age = "";
		String color = "";
		String iceCream = "";
		String city = "";
		for (String string : stringArr) {
			string = string.trim();
			if(string.endsWith("ville")){
				city = string;
			} else if(iceCreamz.contains(string)) {
				iceCream = string;
			} else if(string.contains(" ")) {
				name = string;
			} else if (string.length() > 2) {
				color = string;
			} else {
				age = string;
			}
		}
		writeLine(name + ", " + age + ", " + color + ", " + iceCream + ", " + city +"\n");
	}
	
	public void writeLine(String input) throws IOException {
		if (writer == null) {
			writer =  new FileWriter(new File("output.txt"), false);
			writer.write("");
			writer =  new FileWriter(new File("output.txt"), true);
		}
		writer.write(input);
	}
}
