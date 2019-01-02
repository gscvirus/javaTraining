package com.training.generics.sample.taxation;

public class Dependent extends Individual {
	
	private Coorporation coorporation;
	
	public Dependent(String name, double amount, Coorporation coorporation) {
		super(name, amount);
		setCoorporation(coorporation);
	}
	
	public Coorporation getCoorporation() {
		return this.coorporation;
	}
	
	public void setCoorporation(Coorporation coorporation) {
		this.coorporation=coorporation;
	}

}
