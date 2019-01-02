package com.training.generics.comparison;

import java.util.Iterator;
import java.util.Objects;

public class UtilComparator {

	//public static <E extends Comparable<E>> E max(Iterable<E> iterable) {
	public static <E extends Comparable<? super E>> E max(Iterable<? extends E> iterable) {
		Objects.requireNonNull(iterable);
		
		Iterator<? extends E> iterator=iterable.iterator();
		E result=iterator.next();
		
		while (iterator.hasNext()) {
			E element=iterator.next();			
			if (element.compareTo(result) > 0) {
				result=element;
			}
		}
		
		return result;
	}
	
	
}
