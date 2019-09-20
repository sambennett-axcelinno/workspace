package com.axcelinno.shop;

import java.util.HashMap;
import java.util.Map;

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
		
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.10-SNAPSHOT";
		
		Map<String, Object> params = new HashMap<String, Object>();
		Customers customers = new Customers(1, 1, 400.00, 0.0, false, null, 62284457, 0.0, true);
		Product product = new Product(1,  "laptop", 150.00, 100, true);
		Shop shop = new Shop(false, null, null);
		params.put("c", customers);
		params.put("p",  product);
		params.put("s",  shop);
		
		
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId(groupID, artifactId, version);
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieSession kSession = kContainer.newKieSession();
		KieRuntime kRuntime = (KieRuntime) kSession;
		ProcessInstance processInstance = kRuntime.startProcess("shop-new.shopProcess", params);
		System.out.println(processInstance.getProcessName());
		
		System.out.println(customers.isJobStatus());
		System.out.println(customers.balance);
		
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
		String version = "1.0.10-SNAPSHOT";
		
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
