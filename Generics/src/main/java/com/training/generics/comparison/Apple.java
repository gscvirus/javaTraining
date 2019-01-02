package com.training.generics.comparison;

public final class Apple extends Fruit implements Comparable<Apple>{

	private Apple() {
	}
	
	public static Apple of(double calories, Color color, double weight) {
		Apple apple=new Apple();
		
		apple.setName("Apple");
		apple.setCalories(calories);
		apple.setColor(color);
		apple.setWeight(weight);
		
		return apple;
	}
	
	@Override
	public int compareTo(Apple apple) {
		return super.compareTo(apple);
	}
}
