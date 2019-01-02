package com.training.generics.sample.taxation;

public class Taxable {
	
	protected String name;
	protected double amount;
	
	public Taxable(String name, double amount) {
		this.name=name;
		this.amount=amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	public double compute() {
		double totalAmount=0;
		
		for (int idx=0; idx<12; idx++) {
			totalAmount += amount;
		}
		
		return totalAmount;
	}
}
