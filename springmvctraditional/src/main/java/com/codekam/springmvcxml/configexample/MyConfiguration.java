package com.codekam.springmvcxml.configexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component
@PropertySource("classpath:/customprops/my.properties")
class MyBean{
	@Value("${app.custom.text}")
	private String name;
	public void setName(String name) {this.name=name;}
	public String getName() {return this.name;}
}

class MultiBean{
	public MultiBean() {}
	public MultiBean(String name) {this.name=name;}
	private String name;
	public void setName(String name) {this.name=name;}
	public String getName() {return this.name;}
}

@Configuration
@PropertySource(value = {"classpath:/customprops/my.properties"})
public class MyConfiguration {

	@Autowired Environment env;

	@Bean
	public MyBean myBean() {
		return new MyBean();
	}
	
	@Bean("multiBean")
	public MultiBean multiBean1() {
		return new MultiBean("MUTLI_BEAN -1");
	}
	
	@Bean("multiBean2")
	public MultiBean multiBean2() {
		return new MultiBean("MUTLI_BEAN -2");
	}
	public void showEnv() {
		System.out.println(env);
		System.out.println("\n reading property files value "+env.getProperty("app.custom.text"));
		
	}
}
