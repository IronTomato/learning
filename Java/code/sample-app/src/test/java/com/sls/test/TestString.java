package com.sls.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sls.sample.dao.CityDao;
import com.sls.sample.dao.impl.CityDaoImpl;
import com.sls.sample.entity.City;

public class TestString {

	// @Test
	public void test() {
		System.out.println("Hello maven test");
	}

	// @Test
	public void testSpring() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		City city = context.getBean("city", City.class);
		System.out.println(city);
	}

	// @Test
	public void testCityDao() {
		CityDao dao = new CityDaoImpl();
		City city = dao.findById(0);
		System.out.println(city);
	}

	// @Test
	public void testEncoding1() throws IOException {
		// byte[] bs = Character.valueOf((char) (0x81)).toString().getBytes();
		// for (byte b : bs) {
		// println(Integer.toBinaryString((int) b));
		// }

		File file = new File("E:/Test/xxx.txt");
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		writer.write(Character.valueOf((char) (0x81)).toString());
		writer.flush();
		writer.close();
	}

	// @Test
	public void testEncoding2() throws IOException {
		File file1 = new File("E:/Test/xxx.txt");
		File file2 = new File("E:/Test/xxx2.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "UTF-8"));
		String str = reader.readLine();
		reader.close();
		for (byte b : str.getBytes()) {
			System.out.println(Integer.toHexString((int) (b)) + " ");
		}

		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2), "UTF-8"));
		writer.write(Character.valueOf((char) (0x81)).toString());
		writer.flush();
		writer.close();

	}

	// @Test
	public void testToHexString() {
		println(toHexString("asdfadfadfahdkfajhdfkajdhgfagaldhfladgfalhdgflajhgdfalhdgfajdhgbflajhgdf"));
	}

	 @Test
	public void testStringFormat() {
		println(String.format("%s %s%s ", null,null,123));
	}

	private void println(Object obj) {
		System.out.println(obj);
	}

	private String toHexString(String source) {
		return toHexString(source.getBytes());
	}

	private String toHexString(String source, String charsetName) throws UnsupportedEncodingException {
		return toHexString(source.getBytes(charsetName));
	}

	private String toHexString(String source, Charset charset) {
		return toHexString(source.getBytes(charset));
	}

	private String toHexString(byte[] bytes) {
		final int HEX = 16;
		StringBuilder accum = new StringBuilder();
		accum.append(String.format("%8s ", " "));
		for (int i = 0; i < HEX; i++) {
			accum.append(String.format("%2X ", i));
		}
		for (int i = 0; i < bytes.length; i++) {
			if (i % HEX == 0) {
				accum.append(String.format("%n%08X ", i));
			}
			accum.append(String.format("%02X ", bytes[i]));
		}

		return accum.toString();
	}

	// @Test
	public void testMySqlDataType() {
		println(MySqlDataType.DateAndTime.toString());

		println(enumToString(MySqlDataType.DateAndTime));
	}

	private <E extends Enum<E>> String enumToString(E e) {
		StringValue sv = null;
		try {
			sv = e.getDeclaringClass().getField(e.name()).getAnnotation(StringValue.class);
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		if (sv != null) {
			return sv.value();
		} else {
			return e.toString();
		}
	}

	// @StringValue("MySql数据类型")
	public enum MySqlDataType {
		@StringValue("数字") Numeric {
		},
		@StringValue("日期和时间") DateAndTime {
		},
		@StringValue("文本") String {
		};

		// @Override
		// public String toString() {
		// int l = this.getClass().getAnnotations().length;
		// System.out.println(this.getClass().getName());
		// StringValue stringValue = null;
		// try {
		// stringValue =
		// this.getDeclaringClass().getField(this.name()).getAnnotation(StringValue.class);
		// } catch (NoSuchFieldException e) {
		// e.printStackTrace();
		// } catch (SecurityException e) {
		// e.printStackTrace();
		// }
		// if (stringValue != null) {
		// return stringValue.value();
		// } else {
		// return super.toString();
		// }
		// }
	}

	// @Test
	public void testIntegerTo36BaseString() {
		System.out.println(Long.toString(60466176, 36));
		System.out.println(Long.toString(2116316160L - 1 + 60466176, 36));
	}

	// @Test
	public void testStringFormat1() {
		System.out.println(String.format("%1$s%1$s%1$s%1$s%1$s", "username"));
	}

//	@Test
	public void testStringUtils() {
//		List<String> list;
		String[] arr = new String[]{"234","456"};
		System.out.println(Arrays.asList(arr).size());
	}
	
	public static <T> List<T> arrayToList(T[] arr) {
		List<T> list = new ArrayList<T>(arr.length);
		for (T e : arr) {
			list.add(e);
		}
		return list;
	}
}
