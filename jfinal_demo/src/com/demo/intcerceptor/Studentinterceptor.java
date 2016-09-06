package com.demo.intcerceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class Studentinterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("Before action invoking");
		inv.invoke();
		System.out.println("After action invoking");
	}

}
