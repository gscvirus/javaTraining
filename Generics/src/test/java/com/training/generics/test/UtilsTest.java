package com.training.generics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.training.generics.Utils;

class UtilsTest {

	@Test
	void copyListWithoutBoundsTest() {
		List<Object> dest=Arrays.<Object>asList(1, 2, "three", "four", new ArrayList<String>(), new HashMap<String, String>());
		List<Object> src=Arrays.<Object>asList(Collections.<Long>emptyList(), 2, 2.34, "source");
		
		Utils.copy1(dest, src);
		
		assertThat(dest, hasItems(src.get(0), src.get(1), src.get(2), src.get(3)));
		
		List<Integer> intsDest=Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> intsSrc=Arrays.asList(9, 8, 7, 6);
		Utils.copy(intsDest, intsSrc);
		
		assertThat(intsDest, hasItems(intsSrc.get(0), intsSrc.get(1), intsSrc.get(2)));
		assertThat(intsDest.get(0), Matchers.is(equalTo(intsSrc.get(0))));
		assertThat(intsDest.get(1), Matchers.is(equalTo(intsSrc.get(1))));
	}
	
	@Test
	void copyListWithUpperBoundInSourceTest() {
		List<Number> dest=Arrays.<Number>asList(1, 2, 3.1, 4.3, 5);
		List<? extends Number> src=Arrays.<Number>asList(6.5, 7.3, 8);
		
		Utils.copy2(dest, src);
		
		assertThat(dest, hasItems(6.5, 7.3, 8));
		
		List<Integer> integers=Arrays.asList(6, 7, 8);
		
		Utils.copy2(dest, integers);
		
		assertThat(dest, hasItems(6, 7, 8));
		assertThat(integers.get(0), Matchers.is(equalTo(dest.get(0))));
		assertThat(integers.get(1), Matchers.is(equalTo(dest.get(1))));		
	}
	
	@Test
	void copyListWithLowerBoundInDestTest() {
		List<Object> objs=Arrays.<Object>asList(1, 2, "three", "four", new ArrayList<String>(), new HashMap<String, String>());
		List<Integer> integers=Arrays.asList(6, 7, 8, 9, 10);
		
		Utils.copy3(objs, integers);
		assertThat(objs, hasItems(integers.get(0), integers.get(1), integers.get(2), integers.get(3)));
	}
	
	@Test
	void sumNumbersTest() {
		List<Integer> ints=Arrays.asList(1, 2, 3);
		List<Double> doubles=Arrays.asList(2.78, 3.14);
		List<Number> numbers=Arrays.asList(1, 2, 2.78, 3.14);
		
		double result=Utils.sum(ints);
		assertThat(6.0, Matchers.is(equalTo(result)));
		
		result=Utils.sum(doubles);
		assertThat(5.92, Matchers.is(equalTo(result)));
		
		result=Utils.sum(numbers);
		assertThat(8.92, Matchers.is(equalTo(result)));
		
		List<? extends Number> nums=ints;
		result=Utils.sum(nums);
		assertThat(6.0, Matchers.is(equalTo(result)));
	}

	@Test
	void fillListTest() {
		List<Integer> ints=new ArrayList<Integer>();
		Utils.fill(ints, 5);		
		assertThat(ints, contains(1, 2, 3, 4, 5));
		
		List<Number> numbers=new ArrayList<Number>();
		numbers.add(Double.valueOf(45.6));
		Utils.fill(numbers, 5);
		numbers.add(8.98);		
		assertThat(numbers, contains(45.6, 1, 2, 3, 4, 5, 8.98));
		
		List<Object> objects=new ArrayList<>();
		LocalDate now=LocalDate.now();
		objects.add(now);
		Utils.fill(objects, 5);
		objects.add("last");
		assertThat(objects, contains(now, 1, 2, 3, 4, 5, "last"));
		
		List<? super Integer> integers=new ArrayList<>();
		integers=objects;
		Utils.fill(integers, 5);
		assertThat(integers, contains(now, 1, 2, 3, 4, 5, "last", 1, 2, 3, 4, 5));				
	}
	
	@Test
	void reverseListTest() {
		List<Integer> integers=new ArrayList<>(10);
		
		for (int idx=0; idx<10; idx++) {
			integers.add(idx);
		}
		Utils.reverse(integers);
		
		assertThat(integers, contains(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
		
	}
	
}
