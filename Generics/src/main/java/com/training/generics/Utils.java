package com.training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gonzalo Solano
 *
 */
public class Utils {

	/**
	 * Copies src content of any type that extends from T to dest of type T 
	 * or any superclass of T, starting at index 0.
	 * If the size of the dest list is smaller than the src list an 
	 * IllegalArgumentException is thrown.
	 * 
	 * @param <T> 	type of the elements of the list
	 * @param dest	destination list
	 * @param src	source list
	 */
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		if (dest.size() < src.size()) {
			throw new IllegalArgumentException("dest list is smaller than src list");
		}
		
		int idx=0;
		for (T element : src) {
			dest.set(idx++, element);
		}
	}
	
	/**
	 * Copies src content of type T to dest of type T, starting at index 0.
	 * If the size of the dest list is smaller than the src list an 
	 * IllegalArgumentException is thrown.
	 * 
	 * @param <T> 	type of the elements of the list
	 * @param dest	destination list
	 * @param src	source list
	 */
	public static <T> void copy1(List<T> dest, List<T> src) {
		copy(dest, src);
	}
	
	/**
	 * Copies src content which elements are any subtype of T to dest of type T,
	 * starting at index 0. If the size of the dest list is smaller than the
	 * src list an IllegalArgumentException is thrown
	 *
	 * @param <T> 	type of the elements of the list
	 * @param dest	destination list
	 * @param src	source list
	 */
	public static <T> void copy2(List<T> dest, List<? extends T> src) {
		copy(dest, src);
	}
	
	
	/**
	 * Copies src content which elements are of type T to dest which elements
	 * are any element that is a super type of T,
	 * starting at index 0. If the size of the dest list is smaller than the
	 * src list an IllegalArgumentException is thrown
	 *
	 * @param <T> 	type of the elements of the list
	 * @param dest	destination list
	 * @param src	source list
	 */
	public static <T> void copy3(List<? super T> dest, List<T> src) {
		copy(dest, src);
	}
	
	/**
	 * Sum all the elements of the iterable
	 * 
	 * @param iterable	iterable of numbers
	 * @return			the sum of the numbers in the iterable
	 */
	public static double sum(Iterable<? extends Number> iterable) {
		double result=0;
		
		for (Number number : iterable) {
			result=result + number.doubleValue();
		}
		
		return result;
	}
	
	/**
	 * Fill a list of numbers with n elements
	 * @param nums		List of type numbers or super
	 * @param n			The number of elements to fill/generate starting at 1
	 */
	public static void fill(List<? super Integer> nums, int n) {
		for (int idx=1; idx<=n; idx++) {
			nums.add(idx);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void reverse(List<T> list) {
		T[] array=(T[]) list.toArray();
		
		for (int idx=0; idx<list.size(); idx++) {
			list.set(idx, array[list.size()-idx-1]);
		}
	}
}
