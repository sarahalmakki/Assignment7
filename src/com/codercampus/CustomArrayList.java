package com.codercampus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayList <T> implements customList<T>{
	Object[] items = new Object[10];
    int size = 0;
	@Override
public  boolean add(T item) {
		if (items.length == size) {
			expandBackingObjectArray();
			
		}
		items[size++] = item;
	return true;
}
	@Test
	private void expandBackingObjectArray() {
		// TODO Auto-generated method stub
		Object[] oldArray = items ;
		items = new Object[size * 2];
		for(int i = 0 ; i < oldArray.length; i++) {
			items[i] = oldArray[i];
			
		}
	}
	@Override
	public int getSize() {
		return size ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T get (int index)throws IndexOutOfBoundsException {
		if(index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("Index" + index + "size"+ size);
		}
		return (T) items[index];
	}
	@Test
	public  void should_add_11_items_to_list(){
//		Arrange
		CustomArrayList<Integer> sut = new CustomArrayList<>();
//		Act		
		sut.add(1);sut.add(2);sut.add(3);sut.add(4);sut.add(5);sut.add(6);sut.add(7);
		sut.add(8);sut.add(9);sut.add(10);
// Assert
		for(int i =0 ; i <10; i++) {
			assertEquals(i+1, sut.get(i));
		}
	/**
	 * @param sut
	 */
	}
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index < 0 || index > size ) {
			throw new IndexOutOfBoundsException("Index" + index + "size"+ size);
		}
		@SuppressWarnings("unchecked")
		T removedItem = (T) items[index];
		System.arraycopy(items, index +1, items, index,size-1);
		return removedItem;
		
	}

	
}