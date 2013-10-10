
public interface ByteKataInterface {
	//We want to make two constructors
	//1. A constructor that takes a collection 
	//(array, arraylist, linkedlist pick one)
	
	//2. Later, a constructor that takes a numeric value
	
	public Integer getValue(int index);
	public Integer[] getArray();
	public String toString();
	public boolean equals(ByteKataInterface byteKata);
	public ByteKataInterface and(ByteKataInterface byteKata);
	public ByteKataInterface or(ByteKataInterface byteKata);
	public ByteKataInterface not();
	public ByteKataInterface xor(ByteKataInterface byteKata);
	public ByteKataInterface nand(ByteKataInterface byteKata);
	public ByteKataInterface nor(ByteKataInterface byteKata);
	//This is hard, do it later.
	public Integer convertToNumeric(ByteKataInterface byteKata);
	
}
