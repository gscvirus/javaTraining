package com.training.generics.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.training.generics.Box;
import com.training.generics.BoxImpl;

class BoxTest {

	@Test
	void createBoxTest() {
		Box<Integer> iBox=new BoxImpl<>(4);
		Box<Number> nBox=new BoxImpl<>(3.5);
		
		iBox.put(5);
		
		assertThat(5, Matchers.is(equalTo(iBox.get())));
		assertThat(3.5, Matchers.is(equalTo(nBox.get())));
	}

	@Test
	void putABoxThatExtendsFromTTest() {
		Box<Integer> iBox=new BoxImpl<>(4);
		Box<Number> nBox=new BoxImpl<>(3.5);
		
		nBox.put(iBox);
		
		assertThat(4, Matchers.is(equalTo(iBox.get())));
		assertThat(4, Matchers.is(equalTo(nBox.get())));
	}
	
	@Test
	void compareBoxText() {
		Box<Integer> iBox=new BoxImpl<>(4);
		Box<Number> nBox=new BoxImpl<>(4.5);
		Box<Number> numBox=new BoxImpl<>(5.6);
		
		nBox.put(iBox);
		
		assertThat(false, Matchers.is(equalTo(nBox.containsSame(numBox, nBox.getComparator()))));
	}
	
}
