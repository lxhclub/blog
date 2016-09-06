package com.demo.model;

import com.jfinal.plugin.activerecord.Model;

public class Studentes extends Model<Studentes> {
	private static final long servialVersionUID=1L;
	public static final Studentes dao=new Studentes();
   public Classes getClasses(){
	   Classes classes=Classes.dao.findById(get("classesid"));
   return classes;
   }
}
