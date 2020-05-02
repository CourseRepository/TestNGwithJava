package com.testcase;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomeListener implements IInvokedMethodListener {

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("afterInvocation Method Name : " + arg0.getTestMethod().getMethodName() + " : Class Name : " + arg1.getTestClass().getName());
		
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.out.println("beforeInvocation Method Name : " + arg0.getTestMethod().getMethodName() + " : Class Name : " + arg1.getTestClass().getName());
		
	}

}
