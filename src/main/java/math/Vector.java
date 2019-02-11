package math;

import java.util.ArrayList;

/**
 * @author Dessertion
 */
public class Vector<T extends Number> {
	
	private final int          dim;
	private final ArrayList<T> arr;
	
	/**
	 * Creates a vector with a given dimension and initializes all components to 0
	 * @param dimensions The dimensions of the vector
	 */
	public Vector(int dimensions) {
		this.dim = dimensions;
		arr = new ArrayList<>(dimensions);
		for (int i = 0; i < dimensions; i++) arr.add((T) (Number) (0));
	}
	
	/**
	 * Default constructor; creates a 3-dimensional vector
	 */
	public Vector() {
		this(3);
	}
	
	/**
	 * Creates a vector with the given array
	 * @param a The array to be turned into a vector
	 * @param <S> The type of the vector
	 */
	public <S extends Number> Vector(S[] a){
		dim = a.length;
		arr = new ArrayList<>(dim);
		for(int i = 0 ; i< dim; i++)arr.add((T)a[i]);
	}
	
	/**
	 * Get the value of the element at this index
	 * @param idx The index of the element
	 * @return The value of the element at the index
	 */
	public T get(int idx){
		return arr.get(idx);
	}
	
	/**
	 * Sets the value of this index to another value
	 * @param idx The index to be changed
	 * @param u The value to set the index to
	 * @return The altered vector
	 */
	public Vector set(int idx, T u){
		arr.set(idx,u);
		return this;
	}
	
	public <S> Vector add(Vector v) throws Exception {
		if(dim!=v.dim)throw new VectorDimensionMismatchException(this,v);
		for(int i = 0 ; i < dim; i++)arr.get(dim)+=(T)(Number)(v.get(i));
	}
	
	
	public int getDimension() {
		return dim;
	}
}

