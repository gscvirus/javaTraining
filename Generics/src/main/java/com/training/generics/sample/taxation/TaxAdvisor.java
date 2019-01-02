package com.training.generics.sample.taxation;

import java.util.ArrayList;
import java.util.List;

public class TaxAdvisor {

	private List<Taxable> clients = new ArrayList<>();
	
	public void computeTaxes(Taxable taxable) {
		double tax=taxable.compute();
		
		System.out.println("Amount of tax to pay " + tax);
	}
	
	public List<Taxable> getClients() {
		return this.clients;
	}
	
	public void computeBulkTaxes(List<Taxable> taxables) {
		for (Taxable taxable : taxables) {
			computeTaxes(taxable);
		}
	}
	
	public void computeTaxesFromTaxables(List<? extends Taxable> taxables) {
		for (Taxable taxable : taxables) {
			computeTaxes(taxable);
		}
	}
	
	public void addClients(List<Taxable> clients) {
		
		for (Taxable taxable : clients) {
			this.clients.add(taxable);
		}
	}
	
	public void addClient(List<? super Individual> clients, Individual individual) {		
		clients.add(individual);    
	}
	
	public void addTaxableClient(Taxable client) {
		this.clients.add(client);
	}
}
