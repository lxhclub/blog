package com.lxh.interceptor;

import java.util.Map;

import com.lxh.entity.Manager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class ManagerLoginCheck extends AbstractInterceptor{

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation ai) throws Exception {
		
		Map session = ai.getInvocationContext().getSession();
		Manager manager = (Manager)session.get("loginManager");
		if(manager != null){
			return ai.invoke();
		}else{
			return Action.SUCCESS;
		}
	}

}
