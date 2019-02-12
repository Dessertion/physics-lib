package math;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dessertion
 */
public class Vector{
	private double[] arr;
	private int sz;
	
	public Vector(int size){
		sz=size;
		arr = new double[sz];
	}
	
	public Vector(){
		this(3);
	}
	
	public Vector(double...v){
		arr = v.clone();
		sz = v.length;
	}
	
	public Vector(Vector v){
		arr = v.toArray();
		sz = v.getSize();
	}
	
	public Vector(double size, double val){
		this(size);
		for(var i : arr)i=val;
	}
	
	public List<Double> toList(){
		return Arrays.stream(arr).parallel().boxed().collect(Collectors.toList());
	}
	
	public double[] toArray(){
		return arr;
	}
	
	public Double[] toBoxedArray(){
		return (Double[])Arrays.stream(arr).parallel().boxed().toArray();
	}
	
	public int getSize(){
		return sz;
	}
	
	private void check3D(Vector v) throws InvalidVectorDimensionsException {
		if(sz!=3)throw new InvalidVectorDimensionsException(sz,3);
		if(v.sz!=3)throw new InvalidVectorDimensionsException(v.sz,3);
	}
	
	public double lengthSquared(){
		return Arrays.stream(arr).parallel().map(x->x*x).sum();
	}
	
	public double length(){
		return Math.sqrt(lengthSquared());
	}
	
	public Vector add(Vector v) throws VectorDimensionMismatchException {
		if(v.sz!=sz)throw new VectorDimensionMismatchException(this,v);
		for(int i = 0 ; i<sz; i++)arr[i]+=v.arr[i];
		return this;
	}
	
	public Vector add(double...v) throws VectorDimensionMismatchException {
		return add(new Vector(v));
	}
	
	public Vector sub(Vector v) throws VectorDimensionMismatchException {
		if(v.sz!=sz)throw new VectorDimensionMismatchException(this,v);
		for(int i = 0 ; i < sz; i++)arr[i]-=v.arr[i];
		return this;
	}
	
	public Vector sub(double...v) throws VectorDimensionMismatchException {
		return sub(new Vector(v));
	}
	
	public Vector mul(double scalar){
		arr = Arrays.stream(arr).parallel().map(x->x*scalar).toArray();
		return this;
	}
	
	public Vector div(double scalar){
		arr = Arrays.stream(arr).parallel().map(x->x/scalar).toArray();
		return this;
	}
	
	public Vector mulEach(Vector v) throws VectorDimensionMismatchException {
		if(sz!=v.sz)throw new VectorDimensionMismatchException(this,v);
		for(int i = 0 ; i < sz; i ++)arr[i]*=v.arr[i];
		return this;
	}
	
	public Vector mulEach(double...v)throws VectorDimensionMismatchException{
		return mulEach(new Vector(v));
	}
	
	public Vector divEach(Vector v) throws VectorDimensionMismatchException{
		if(sz!=v.sz)throw new VectorDimensionMismatchException(this,v);
		for(int i = 0; i<sz; i++)arr[i]/=v.arr[i];
		return this;
	}
	
	public Vector divEach(double...v)throws VectorDimensionMismatchException{
		return divEach(new Vector(v));
	}
	
	public double dot(Vector v) throws VectorDimensionMismatchException {
		if(v.sz!=sz)throw new VectorDimensionMismatchException(this,v);
		double ret = 0;
		for (int i = 0; i < sz; i++) ret+=arr[i]*v.arr[i];
		return ret;
	}
	
	public double dot(double...v)throws VectorDimensionMismatchException{
		return dot(new Vector(v));
	}
	
	public static double dot(Vector u, Vector v) throws VectorDimensionMismatchException {
		return u.dot(v);
	}
	
	public Vector cross(Vector v) throws InvalidVectorDimensionsException {
		if(sz!=3)throw new InvalidVectorDimensionsException(sz,3);
		if(v.sz!=3)throw new InvalidVectorDimensionsException(v.sz,3);
		return new Vector(arr[1]*v.arr[2]-arr[2]*v.arr[1],arr[2]*v.arr[0]-arr[0]*v.arr[2],arr[0]*v.arr[1]-arr[1]*v.arr[0]);
	}
	
	public Vector cross(double...v) throws InvalidVectorDimensionsException {
		return cross(new Vector(v));
	}
	
	public static Vector cross(Vector u, Vector v)throws InvalidVectorDimensionsException{
		return u.cross(v);
	}
	
	public Vector normalize(){
		double len = length();
		return div(len);
	}
	
	public Vector zero(){
		arr = Arrays.stream(arr).parallel().map(x->0).toArray();
		return this;
	}
	
}

