
public class OverTenException extends Exception {
	final private static String ERROR = "Yo Dawg you be rollin' over ten";
	
	public OverTenException() {
		super(ERROR);
	}
}
