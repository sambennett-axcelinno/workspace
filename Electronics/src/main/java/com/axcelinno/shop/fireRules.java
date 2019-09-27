package com.axcelinno.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.rule.FactHandle;

public class fireRules {
	
	public fireRules() {
		
	}
	
	public static void main(String[] args) {
		/*1.0.13 is last version before  testProcess with gateway testing*/
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.18-SNAPSHOT";
		/*1.0.18 for working list thing*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		Customers customers = new Customers(1, 1, 400.00, 0.0, false, null, 62284457, 0.0, true);
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		product.add = true;
		Product product2 = new Product(2,  "TV", 550.00, 100, true);
		product2.add = true;
		Product product3 = new Product(3,  "PC", 650.00, 100, true);
		product3.add = true;
		Shop shop = new Shop(false, null, null);
		listOfProd lProd = new listOfProd();
		//lProd.addTo(product);
		//lProd.addTo(product2);
		//lProd.addTo(product3);
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		list.add(product2);
		list.add(product3);
		params.put("c", customers);
		params.put("p",  product);
		params.put("l",  list);
		System.out.println(lProd.prodListSize());
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID, artifactId, version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("shop-new.addProcess", params);
		System.out.println(processInstance.getProcessName());
		
		System.out.println(customers.cartSize());
		System.out.println(lProd.prodListSize());
		System.out.println(lProd.getProdList().get(0).toString());
		System.out.println(lProd.getProdList().get(1).toString());
		System.out.println(lProd.getProdList().get(2).toString());
		
		System.out.println("passes");
		
		
		/*
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.0-SNAPSHOT";
		
		KieServices ks = KieServices.Factory.get();
		
		ReleaseId releaseId = ks.newReleaseId(groupID,  artifactId,  version);
		
		KieContainer kContainer = ks.newKieContainer(releaseId);
		
		KieSession kSession = kContainer.newKieSession();
		
		kSession.fireAllRules();
		
		System.out.println("works");
		*/
	}
	
	public void runProcess(Customers c, Product p, Shop s) {
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.15-SNAPSHOT";
		/*1.0.10-SNAPSHOT for version that worked*/
		/*now 1.0.14 works as expected for shopProcess 1.0.13 might be better than 1.0.14*/
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c", c);
		params.put("p",  p);
		params.put("s",  s);
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID, artifactId, version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("shop-new.shopProcess", params);
	}
	
	public void runWithData(Customers c, Product p, Shop s) {
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.0-SNAPSHOT";
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID,  artifactId,  version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		
		FactHandle factHandle;
		factHandle = kSession.insert(p);
		factHandle = kSession.insert(c);
		factHandle = kSession.insert(s);
		
		int num = kSession.fireAllRules();
		System.out.println(num);
	}
	

}
