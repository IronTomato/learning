package com.sls.test;

import static org.junit.Assert.*;

import java.beans.Beans;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BeanTest {

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// A a = new A();
		// a.setName("wnb");
		// B b = (B) Beans.getInstanceOf(a, B.class);
		//
		B b = new B();
		b.setName("wnb");
//		for (PropertyDescriptor pd : BeanUtils.getPropertyDescriptors(B.class)) {
//			System.out.println(pd);
//			System.out.println(pd.getReadMethod().invoke(b, null)); 
//			System.out.println(pd.getWriteMethod());
//			
//		}
		Arrays.asList(BeanUtils.getPropertyDescriptors(B.class)).stream()
			.filter(pd -> pd.getWriteMethod() != null).forEach(pd -> {
				System.out.println(pd.getWriteMethod().getParameterTypes()[0].getName());
				Class paramClass = pd.getWriteMethod().getParameterTypes()[0];
				if(paramClass == Integer.class){
					try {
						pd.getWriteMethod().invoke(b, new Integer(2));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		System.out.println(b);
	}

}

class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class B {
	private String name;
	private Integer id;
	private boolean isMan;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public boolean isMan() {
		return isMan;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}

	@Override
	public String toString() {
		return "B [name=" + name + ", id=" + id + ", isMan=" + isMan + "]";
	}
	
	
}
