package com.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class Retry implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class arg1, Constructor arg2,
			Method arg3) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if(retry == null)
			annotation.setRetryAnalyzer(CustomRetryListener.class);
		
	}

}
