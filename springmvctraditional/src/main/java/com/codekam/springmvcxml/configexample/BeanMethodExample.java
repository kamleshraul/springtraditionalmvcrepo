package com.codekam.springmvcxml.configexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

abstract class  ExampleParent {
	public int instances=0; 
	public int instanceCount() { return ++instances;}
	public void printInstanceCount(String name,int count) {
		System.out.println(String.format("%s -- %d", name,count));
	}
}

class Foo extends ExampleParent{ 
	Foo() {
		printInstanceCount("Foo", instanceCount());
	}
}

class Bar extends ExampleParent{
	Bar(){printInstanceCount("Bar", instanceCount());}
}

class FooRepository extends ExampleParent{ 
	private Foo foo;
	public FooRepository() {
		printInstanceCount("FooRepository", instanceCount());
	}
	
	public void setFoo(Foo foo) {
		this.foo=foo;
	}
}
class BarRepository extends ExampleParent{
	Bar bar;
	public BarRepository() {
		printInstanceCount("BarRepository", instanceCount());
	}
	
	public void setBar(Bar bar) {
		this.bar=bar;
	}
}

/*
 * Bean annotated methods can be directly called from other
 * bean method  which will not result in creation of new bean
 * instead CGLIB will intercept it so that inter-bean-reference
 * is maintained
 * */
@Configuration
class BeanMethodConfiguration{
	
	@Bean public Foo foo() { return new Foo();}
	
	@Bean public Bar bar() {return new Bar();}
	
	@Bean public FooRepository fooRepository() {
		FooRepository fr = new FooRepository();
		fr.setFoo(foo());
		return fr;
	}
	
	@Bean public BarRepository barRepository() {
		BarRepository br = new BarRepository();
		br.setBar(bar());
		return br;
	}
	
}

/*Lightmode where bean method defined in non configuration 
 * classes , where calling bean method from another bean method
 * result in plain method call i.e. Spring CGLIB doesnot intercept
 * to call by providing proxies
 * 
 * */
class BeanMethodNotConfiguration{
	
	@Bean(name="Foo_From_NonConfiguration")
	public Foo foo() {
		System.out.println("Bean From non configuration class");
		return new Foo();
	}
	
	@Bean public FooRepository fooRepository() {
		System.out.println("Bean From non configuration class");
		FooRepository fr = new FooRepository();
		fr.setFoo(foo());
		return fr;
	}
}


public class BeanMethodExample {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(BeanMethodConfiguration.class);
		context.register(BeanMethodNotConfiguration.class);
		context.refresh();
	}
}
