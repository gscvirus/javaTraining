package com.training.generics;

public interface Box<T> {
	public T get();
	public EqualityComparator<T> getComparator();
	public void put(T element);
	public void put(Box<? extends T> box);
	public void copy(Box<? super T> to, Box<? extends T> from);
	
	boolean containsSame(Box<? extends T> other, EqualityComparator<? super T> comparator);
	
	public interface EqualityComparator<T> {
		public boolean compare(T first, T second);
	}
}
