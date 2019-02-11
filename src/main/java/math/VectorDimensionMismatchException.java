package math;

/**
 * @author Dessertion
 */
public class VectorDimensionMismatchException extends Exception {
	
	public VectorDimensionMismatchException(Vector a, Vector b){
		super("Vector dimensions do not match!\nFirst vector's dimension: " + a.getDimension()+"\nSecond vector's dimension: " + b.getDimension());
	}
	
}

