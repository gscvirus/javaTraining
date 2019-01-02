package com.training.generics;

/**
 * Java sample took from https://www.ibm.com/developerworks/library/j-jtp07018/index.html
 * 
 * @author Gonzalo Solano
 *
 * @param <T>
 */
public class BoxImpl<T> implements Box<T> {

	private T element;
	
	public static EqualityComparator<Object> sameObjectComparator=new EqualityComparator<Object>() {
		public boolean compare(Object first, Object second) {
			return first == second;
		}
	};
	
	private EqualityComparator<T> genericComparator=new EqualityComparator<T>() {
		public boolean compare(T first, T second) {
			return first == second;
		}
	};
	
	public BoxImpl(T element) {
		this.element=element;
	}
	
	@Override
	public T get() {
		return element;
	}
	
	@Override 
	public EqualityComparator<T> getComparator() {
		return genericComparator;
	}
	
	@Override
	public void put(T element) {
		this.element=element;
	}
	 
	@Override
	public void put(Box<? extends T> box) {
		this.put(box.get());
	}
	
	@Override
	public void copy(Box<? super T> to, Box<? extends T> from) {
		to.put(from);
	}

	@Override
	public boolean containsSame(Box<? extends T> other, EqualityComparator<? super T> comparator) {
		
		return comparator.compare(this.get(), other.get());
	}
	
}
