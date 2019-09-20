package com.axcelinno.shop;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class fireRules {
	
	public fireRules() {
		
	}
	
	public static void main(String[] args) {
		String groupID = "com.myspace";
		String artifactId = "shop-new";
		String version = "1.0.0-SNAPSHOT";
		
		KieServices ks = KieServices.Factory.get();
		
		ReleaseId releaseId = ks.newReleaseId(groupID,  artifactId,  version);
		
		KieContainer kContainer = ks.newKieContainer(releaseId);
		
		KieSession kSession = kContainer.newKieSession();
		
		kSession.fireAllRules();
		
		System.out.println("works");
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
