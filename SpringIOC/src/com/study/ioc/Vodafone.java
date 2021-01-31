package com.study.ioc;

public class Vodafone implements Sim {

	public void call() {
		System.out.println("calling from vodafone sim");

	}

	public void data() {
		System.out.println("browsing from vodafone sim");

	}

}
