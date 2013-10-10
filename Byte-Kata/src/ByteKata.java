public class ByteKata implements ByteKataInterface {
	//We want to make two constructors
	//1. A constructor that takes a collection 
	//(array, arraylist, linkedlist pick one)

	//2. Later, a constructor that takes a numeric value
	private Integer[] array;
	public ByteKata(Integer[] array) {
		this.array = array;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteKataInterface nor(ByteKataInterface byteKata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer convertToNumeric(ByteKataInterface byteKata) {
		// TODO Auto-generated method stub
		return null;
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
}
