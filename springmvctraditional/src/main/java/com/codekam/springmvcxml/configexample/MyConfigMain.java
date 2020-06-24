package com.codekam.springmvcxml.configexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyConfigMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext();
		appContext.register(MyConfiguration.class);
		//appContext.register(MyBean.class);
		appContext.refresh();
		
		MyConfiguration bean = appContext.getBean(MyConfiguration.class);
		MyBean myBean = appContext.getBean(MyBean.class);
		bean.showEnv();
		System.out.println("MyBean Name : "+myBean.getName());
		
		MultiBean multiBean=appContext.getBean("multiBean",MultiBean.class);
		System.out.println("MultiBean Injected : "+multiBean.getName());
	}
}
