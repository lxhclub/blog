package com.demo.config;

import com.demo.controller.ClassController;
import com.demo.controller.StudentController;
import com.demo.model.Classes;
import com.demo.model.Studentes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class DemoConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/", StudentController.class);
	   me.add("/student", StudentController.class);
	   me.add("/classes", ClassController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin c3=new C3p0Plugin("jdbc:mysql://localhost/excel?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull","root","root");
		me.add(c3);
		ActiveRecordPlugin arp=new ActiveRecordPlugin(c3);
		arp.setShowSql(true);	
		arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));	
		me.add(arp);
		arp.addMapping("student","studentid",Studentes.class);
		arp.addMapping("classes","classesid",Classes.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
//		JFinal.start("WebRoot",80,"/",5);
	}

}
