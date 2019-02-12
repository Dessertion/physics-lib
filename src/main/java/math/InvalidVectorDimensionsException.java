package math;

/**
 * @author Dessertion
 */
public class InvalidVectorDimensionsException extends Exception {
	public InvalidVectorDimensionsException(int given, int expected){
		super("Invalid dimensions! Expected # of dimensions: " + expected + ". Given # of dimensions: " + given);
	}
	
}

