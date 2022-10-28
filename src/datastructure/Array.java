package datastructure;

public class Array <T>{
	private T[] array;
	private int length = 0;
	private int capacity = 0;
	
	public Array() {
		this(16);
	}
	
	public Array(int capacity) {
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public void set(int index, T element) {
		array[index] = element;
	}
	
	public void clear() {
		for(int i = 0; i < capacity; i++) {
			array[i] = null;
		}
		length = 0;
	}
	
	public void add(T element) {
		if(length + 1 >= capacity) {
			if(capacity ==0) capacity =1;
			else capacity *= 2;
		T[] new_array = (T[]) new Object[capacity];
		for(int i =0; i < length; i++) {
			new_array[i] = array[i];
			array = new_array;
		}
		
		array[length++] = element;
		}
	}
	
	public T removeAt(int rm_index) {
		if(rm_index >=length && rm_index < 0) throw new IndexOutOfBoundsException();
		T data = array[rm_index];
		T[] new_array = (T[]) new Object[length-1];
		for(int i = 0, j=0; i < length; i++) {
			if(i == rm_index) j--;
			else new_array[j] = array[i];
		}
		array = new_array;
		capacity = --length;
		return data;
	}
	
	public boolean remove(Object obj) {
		for(int i =0; i < length; i ++) {
			if(array[i].equals(obj)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(Object obj) {
		for(int i =0; i<length;i ++) {
			if(array[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		return indexOf(obj)!=-1;
	}
}
