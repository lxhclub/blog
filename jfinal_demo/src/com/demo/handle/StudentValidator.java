package com.demo.handle;
import com.demo.model.Studentes;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class StudentValidator extends Validator {
	 //��У��ʧ��ʱ�Ż����
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
        //��֤����name��������Ϣkey,������Ϣvalue
        validateRequiredString("studentes.studentname", "studentesnameMsg",
                "������ѧ��������!");
        validateRequiredString("studentes.studentage", "studentesageMsg",
                "������ѧ��������!");
        validateRequiredString("studentes.studentsex", "studentessexMsg",
                "������ѧ�����Ա�!");
        validateRequiredString("studentes.classid", "classidMsg",
                "������ѧ���İ༶id!");
        
    }

}
