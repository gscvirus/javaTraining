package com.training.generics.comparison;

public class Orange extends Fruit implements Comparable<Orange> {

	private Orange() {
	}
	
	public static Orange of(double calories, Color color, double weight) {
		Orange orange=new Orange();
		
		orange.setName("Orange");
		orange.setCalories(calories);
		orange.setColor(color);
		orange.setWeight(weight);
		
		return orange;
	}

	@Override
	public int compareTo(Orange orange) {
		return super.compareTo(orange);
	}
}
