package com.testngclasses;

import org.testng.annotations.Test;

public class TestStaticMethod {
	
	@Test
	public void StaticMethodTest() {
		System.out.println("Class Name " + this.getClass().getCanonicalName());
	}

}
