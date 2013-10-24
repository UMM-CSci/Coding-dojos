import java.util.HashMap;

public class ByteKata implements ByteKataInterface {
	//We want to make two constructors
	//1. A constructor that takes a collection 
	//(array, arraylist, linkedlist pick one)

	//2. Later, a constructor that takes a numeric value
	private Integer[] array;
	HashMap<Integer, Integer> bitValues = new HashMap<Integer, Integer>();
	HashMap<Integer, String> hexaValues = new HashMap<Integer, String>();
	public ByteKata(Integer[] array) {
		this.array = array;
		bitValues.put(0, 128);
		bitValues.put(1, 64);
		bitValues.put(2, 32);
		bitValues.put(3, 16);
		bitValues.put(4, 8);
		bitValues.put(5, 4);
		bitValues.put(6, 2);
		bitValues.put(7, 1);
		hexaValues.put(10, "A");
		hexaValues.put(11, "B");
		hexaValues.put(12, "C");
		hexaValues.put(13, "D");
		hexaValues.put(14, "E");
		hexaValues.put(15, "F");
	}

	@Override
	public ByteKataInterface and(ByteKataInterface byteKata) {
		Integer[] toReturn = new Integer[8];
		for (int i = 0; i < 8; i++) {
			if (byteKata.getValue(i) == array[i]) {
				toReturn[i] = array[i];
			}
			else {
				toReturn[i] = 0;
			}
		}

		return new ByteKata(toReturn);
	}

	@Override
	public ByteKataInterface or(ByteKataInterface byteKata) {
		Integer[] toReturn = new Integer[8];
		for (int i = 0; i < 8; i++) {
			if (array[i] == 1 || byteKata.getValue(i) == 1){
				toReturn[i] = 1;
			} else {
				toReturn[i] = 0;
			}
		}

		return new ByteKata(toReturn);
	}

	@Override
	public ByteKataInterface not() {
		Integer[] toReturn = new Integer[8];
		for (int i = 0; i < 8; i++) {
			if (array[i] == 0) {
				toReturn[i] = 1;
			} else {
				toReturn[i] = 0;
			}
		}
		
		return new ByteKata(toReturn); 
	}

	@Override
	public ByteKataInterface xor(ByteKataInterface byteKata) {
		Integer[] toReturn = new Integer[8];
		
		for(int i = 0; i < 8; i++) {
			toReturn[i] = (array[i] + byteKata.getValue(i)) % 2;
		}
		
		return new ByteKata(toReturn);
	}

	@Override
	public ByteKataInterface nand(ByteKataInterface byteKata) {
		return this.and(byteKata).not();
	}

	@Override
	public ByteKataInterface nor(ByteKataInterface byteKata) {
		return this.or(byteKata).not();
	}

	@Override
	public Integer convertToNumeric() {
		Integer toReturn = 0;
		for (int i = 0; i < this.array.length; i++) {
			Integer bitValue = this.bitValues.get(i);
			Integer arrayValue = this.array[i];
			toReturn += bitValue*arrayValue;
		}
		return toReturn;
	}

	@Override
	public boolean equals(ByteKataInterface byteKata) {
		boolean toReturn = true;
		for (int i = 0; i < array.length; i++) {
			if(!array[i].equals(byteKata.getValue(i))){
				toReturn = false;
			}
		}
		return toReturn;
	}

	@Override
	public Integer getValue(int index) {
		
		return array[index];
	}

	@Override
	public Integer[] getArray() {
		Integer[] toReturn = array.clone();
		return toReturn;
	}

	@Override
	public String toString(){
		String toString = "[";
		for (Integer integer : array) {
			toString += "" + integer + ", ";
		}
		toString = toString.substring(0, toString.length() -2);
		toString += "]";
		return toString;
	}

	@Override
	public ByteKataInterface add(ByteKataInterface byteKata) {
		Integer carry = 0;
		Integer[] results = new Integer[8];
		for(int i = 7;i >= 0;i--){
			Integer self = this.array[i];
			Integer other = byteKata.getValue(i);
			Integer result = self + other + carry;
			carry= result>=2  ?  1:0;
			result = result%2;
			results[i] = result;
		}
		return new ByteKata(results);
	}
	
	@Override
	public String toHEX() {
		String toReturn = "";
		Integer firstHalf = 0;
		firstHalf += bitValues.get(4)*array[0];
		firstHalf += bitValues.get(5)*array[1];
		firstHalf += bitValues.get(6)*array[2];
		firstHalf += bitValues.get(7)*array[3];
		
		Integer secondHalf = 0; 
		secondHalf += bitValues.get(0)*array[0];
		secondHalf += bitValues.get(1)*array[1];
		secondHalf += bitValues.get(2)*array[2];
		secondHalf += bitValues.get(3)*array[3];
		String firstString = "";
		String secondString = "";
		if(firstHalf > 9){
			firstString = hexaValues.get(firstHalf);
		} else {
			firstString = firstHalf.toString();
		}
		if(secondHalf > 9){
			secondString = hexaValues.get(secondHalf);
		} else {
			secondString = secondHalf.toString();
		}
		toReturn = firstString + secondString;
		
		return toReturn;
	}
}
