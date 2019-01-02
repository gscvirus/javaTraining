package com.training.generics.comparison.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.training.generics.comparison.Apple;
import com.training.generics.comparison.Color;
import com.training.generics.comparison.Fruit;
import com.training.generics.comparison.UtilComparator;

class FruitComparatorTest {

	@Test
	void maxAppleTest() {
		Apple apple = Apple.of(5.8, Color.RED, 10.3);
		List<Fruit> apples=Arrays.asList(
										 Apple.of(3.5, Color.RED, 1.2)
									   , Apple.of(4.5, Color.GREEN, 3.1)
									   , Apple.of(2.3, Color.RED, 1.4)
									   , apple
									);
		//Apple maxApple = (Apple) UtilComparator.<Fruit>max(apples);
		//assertThat(maxApple, Matchers.is(equalTo(apple)));
		
	}

}
