package com.training.generics.comparison;

public abstract class Fruit {

	protected String name;
	protected double calories;
	protected Color color;
	protected double weight;
	
	protected Fruit() {
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getCalories() {
		return this.calories;
	}
	
	public void setCalories(double calories) {
		this.calories=calories;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight=weight;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() * 29 + (int)Math.round(this.weight);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj instanceof Fruit) {
			Fruit fruit = (Fruit)obj;
			
			return this.name.equals(fruit.name) && this.weight == fruit.weight;
		}
		return false;
	}

	protected int compareTo(Fruit otherFruit) {
		return this.weight < otherFruit.weight ? -1 :
			   this.weight == otherFruit.weight ? 0 : 1;
	}
}
