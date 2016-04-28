package com.sls.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import org.junit.Test;

public class TestDynamicProxy {

	@Test
	public void test() {
		TimeSerivce target = new TimeServiceImpl();
		LogHandler handler = new LogHandler(target);
		TimeSerivce proxy = (TimeSerivce) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		target.printTime();
		System.out.println("=======================");
		proxy.printTime();
	}

	public interface TimeSerivce {
		void printTime();
	}

	public static class TimeServiceImpl implements TimeSerivce {

		public void printTime() {
			System.out.println(new Date());
		}

	}

	public static class LogHandler implements InvocationHandler {

		private Object target;

		public LogHandler(Object target) {
			this.target = target;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("Before method invoke");
			Object obj = method.invoke(target, args);
			System.out.println("After method invoke");
			return obj;
		}
	}
}
