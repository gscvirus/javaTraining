package com.training.generics.sample.taxation.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.training.generics.sample.taxation.Coorporation;
import com.training.generics.sample.taxation.Dependent;
import com.training.generics.sample.taxation.Individual;
import com.training.generics.sample.taxation.TaxAdvisor;
import com.training.generics.sample.taxation.Taxable;

class TaxationTest {

	@Test
	void computeTaxesTest() {
		List<Taxable> clients=new ArrayList<>();
		Coorporation tr=new Coorporation("Thomson Reuters", 1000);
		
		clients.add(new Individual("Individual 1", 100));
		clients.add(tr);
		clients.add(new Dependent("Rene", 100, tr));
		
		TaxAdvisor advisor=new TaxAdvisor();
		
		// this works fine because clients is of type taxable
		advisor.computeBulkTaxes(clients);
		
		List<Coorporation> coorporations=new ArrayList<>();
		
		coorporations.add(tr);
		coorporations.add(new Coorporation("Coca cola", 1000));
		coorporations.add(new Coorporation("Pepsi cola", 2000));
		// this works because Coorporation extends from Taxable
		advisor.computeTaxesFromTaxables(coorporations);
	}
	
	@Test
	void addTaxableClientsTest() {
		List<Taxable> clients=new ArrayList<>();
		List<? super Individual> individuals=new ArrayList<>();
		Coorporation tr=new Coorporation("Thomson Reuters", 1000);
		TaxAdvisor advisor=new TaxAdvisor();
		List<Dependent> dependents=new ArrayList<>();
		
		clients.add(new Individual("Individual 1", 100));
		clients.add(tr);
		clients.add(new Dependent("Rene", 100, tr));
		
		dependents.add(new Dependent("Rene", 100, tr));
		dependents.add(new Dependent("Yo", 2000, tr));
		dependents.add(new Dependent("Caro", 3000, tr));

		advisor.addClients(clients);
		
		assertThat(3, Matchers.is(equalTo(advisor.getClients().size())));
		
		advisor.addClient(individuals, new Dependent("Jala", 1000.1, tr));
		individuals.add(new Dependent("Caro", 3000, tr));
		assertThat(2, Matchers.is(equalTo(individuals.size())));
	}

	@Test
	void addCoorporationsClientsTest() {
		List<Coorporation> coorporations=new ArrayList<>();
		TaxAdvisor advisor=new TaxAdvisor();
		Coorporation tr=new Coorporation("Thomson Reuters", 1000);
		
		coorporations.add(tr);
		coorporations.add(new Coorporation("Coca cola", 1000));
		coorporations.add(new Coorporation("Pepsi cola", 2000));
		
		for (Taxable taxable : coorporations) {
			advisor.addTaxableClient(taxable);
		}
		
		assertThat(3, Matchers.is(equalTo(advisor.getClients().size())));
	}
}
