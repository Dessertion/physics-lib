package math;

/**
 * @author Dessertion
 */
public class VectorDimensionMismatchException extends Exception {
	
	public VectorDimensionMismatchException(Vector a, Vector b){
		super("Vector dimensions do not match!\nFirst vector's dimension: " + a.getSize()+"\nSecond vector's dimension: " + b.getSize());
	}
	
	public VectorDimensionMismatchException(Vector a, int b){
		super("Vector dimensions do not match!\nFirst vector's dimension: " + a.getSize()+"\nSecond vector's dimension: " + b);
	}
	
}

