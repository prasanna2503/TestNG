package org.tcs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class FailedAll implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class c, Constructor con, Method m) {
		IRetryAnalyzer analyzer = annotation.getRetryAnalyzer();
		if (analyzer==null) {
			annotation.setRetryAnalyzer(Failed.class);
		}
	}
	
}
