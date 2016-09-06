package com.demo.handle;
import com.demo.model.Studentes;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class StudentValidator extends Validator {
	 //在校验失败时才会调用
    protected void handleError(Controller controller) {
    	String actionKey=getActionKey();
    	String view=null;
    	controller.keepModel(Studentes.class);
    	System.out.println(controller.keepModel(Studentes.class));	
    	if("/student/save".equals(actionKey)){
    		view="/add.html";
    	}
    	controller.renderFreeMarker(view);	
    }
    protected void validate(Controller controller) {
        //验证表单域name，返回信息key,返回信息value
        validateRequiredString("studentes.studentname", "studentesnameMsg",
                "请输入学生的姓名!");
        validateRequiredString("studentes.studentage", "studentesageMsg",
                "请输入学生的年龄!");
        validateRequiredString("studentes.studentsex", "studentessexMsg",
                "请输入学生的性别!");
        validateRequiredString("studentes.classid", "classidMsg",
                "请输入学生的班级id!");
        
    }

}
