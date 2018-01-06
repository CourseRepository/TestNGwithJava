package com.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*Create a custom class that implements IRetryAnalyzer interface.

Override the public boolean retry 

Make this method to return true, if you want to retry else return false.

Use @Test(retryAnalyzer=CustomRetryListener.class) with test method

Other approach to use testng.xml
*/



public class CustomRetryListener implements IRetryAnalyzer {

	/*
	 * retryCount
	 * MAX_RETRY_COUNT
	 * */
	
	private int retryCount = 1;
	private final int MAX_RETRY_COUNT = 5;
	
	@Override
	public boolean retry(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE && retryCount <= MAX_RETRY_COUNT){
			try {
				Thread.sleep(3000);
				System.out.println(String.format("Method Name : %s Retry Count : %d", result.getName(),retryCount));
				retryCount++;
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}

}
