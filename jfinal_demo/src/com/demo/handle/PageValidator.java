package com.demo.handle;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class PageValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		 validateRequiredString("pageNumber", "PageMsg",
	                "²»ÄÜ·­Ò³!");
	}
	@Override
	protected void handleError(Controller c) {
			   	String actionKey=getActionKey();
		    	String view=null;
		    	c.keepPara("pageNumber");
		    	if("/student/getpage".equals(actionKey)){
		    		view="/error.html";
		    	}
		    	c.render(view);	
   }
}