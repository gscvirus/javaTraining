package com.training.generics.comparison.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.training.generics.comparison.UtilComparator;

class ComparatorTest {	

	@Test
	void maxTest() {
		List<Integer> ints=Arrays.asList(1, 6, 2, 3, 4, 5);
		List<String> numbers=Arrays.asList("zero", "one", "two");
		
		Integer max=UtilComparator.max(ints);
		String zero=UtilComparator.max(numbers);
		
		assertThat(max, Matchers.is(equalTo(6)));
		assertThat(zero, Matchers.is(equalTo("zero")));
	}

}
