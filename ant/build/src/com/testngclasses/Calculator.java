package com.testngclasses;

public class Calculator {
	
	private int a;
	private int b;
	int exp;
	
	public Calculator(int a,int b,int exp){
		this.a = a;
		this.b = b;
		this.exp = exp;
	}
	
	public int getSum() {
		return (a + b);
	}

}
