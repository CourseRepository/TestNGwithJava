package com.testcase;

import java.util.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;

public class CustomeIsuiteListener implements ISuiteListener {

	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("=============onFinish=========");
		List<ITestNGMethod> list = arg0.getAllMethods();
		for(ITestNGMethod obj : list){
			System.out.println("Test Method Name : " + obj.getMethodName());
		}
		
	}

	@Override
	public void onStart(ISuite arg0) {
		System.out.println("onStart  Suite Name : " + arg0.getName());
		
	}

}
