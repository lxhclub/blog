package com.demo.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Classes extends Model<Classes> {
	private static final long servialVersionUID=1L;
	public static final Classes dao=new Classes();
	public List<Studentes>getStudents(){
		return Studentes.dao.find("select * from student where classesid=?",get("classesid"));
		
	}

}
