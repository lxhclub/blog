package com.demo.controller;

import com.demo.handle.StudentValidator;
import com.demo.intcerceptor.Studentinterceptor;
import com.demo.model.Studentes;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class StudentController extends Controller {
 @Before(Studentinterceptor.class)
 public void index(){
	 String sql="from student";
	 int pageNumber=getParaToInt("pageNumber",1);
	 setAttr("pageNumber", pageNumber);
	 setAttr("studentList", Studentes.dao.paginate(pageNumber, 5," select *", sql));
	 render("/index.html");
	 
 }
 public void add(){
	 render("/add.html");
		 
	 }
 public void delete(){
     // 获取表单域名为studentid的值
     //Studentes.dao.deleteById(getPara("studentid"));
     // 获取url请求中第一个值
 	int id=getParaToInt();
 	boolean flag=Studentes.dao.deleteById(id);
 	if(flag){
     forwardAction("/student");
 	}else{
 		renderText("DELETE ERROR!");
 	}
 }
 @Before(StudentValidator.class)
 public void update() {
     Studentes studentes = getModel(Studentes.class);
     studentes.update();
     forwardAction("/student");
 }
 
 public void getpage(){
 	String sql="from student";
 	int newnumber=getParaToInt();
 	setAttr("pageNumber",newnumber);
 	System.out.println(newnumber);
 	int pageNumber=getParaToInt("pageNumber",newnumber);
 	setAttr("pageNumber",pageNumber);
 	setAttr("studentList",Studentes.dao.paginate(pageNumber, 5, "select *", sql));
 	render("/index.html");
 }
 
 public void get() {
     Studentes student = Studentes.dao.findById(getParaToInt());
     setAttr("studentes", student);
     render("/index2.html");
 }
 
 //@Before(StudentValidator.class)
 public void save() {
     Studentes student = getModel(Studentes.class);
		boolean flag=student.save();
		if(flag){
     redirect("/student/");
		}else{
			renderText("Error");
		}
 }
}
