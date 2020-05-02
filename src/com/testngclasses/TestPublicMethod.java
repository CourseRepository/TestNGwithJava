package com.testngclasses;

import org.testng.annotations.Test;

public class TestPublicMethod {
	@Test
	public void PublicMethodTest() {
		System.out.println("Class Name " + this.getClass().getCanonicalName());
	}
	@Test
	public void anotherPublicMethodTest() {
		System.out.println("anotherPublicMethodTest");
		//System.out.println("Class Name " + this.getClass().getCanonicalName());
	}
}
