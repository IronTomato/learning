package org.wnb.util;

import java.util.Random;

public class RandomCode {

	private static final String numeric = "0123456789";
	private static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	private static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 从指定的源中生成指定长度的随机码
	 * 
	 * @param length
	 * @param source
	 * @return
	 */
	public static String random(int length, CharSequence source) {
		if (length <= 0)
			throw new IllegalArgumentException("length should be positive");
		if (source == null || source.length() == 0)
			throw new IllegalArgumentException("source should not be blank");
		char[] codeChars = new char[length];
		Random random = new Random();
		for (int i = 0; i < codeChars.length; i++) {
			codeChars[i] = source.charAt(random.nextInt(source.length()));
		}
		return new String(codeChars);
	}

	/**
	 * 生成指定长度，指定类型的随机码
	 * 
	 * @param length
	 * @param type
	 * @return
	 * @see CodeType
	 */
	public static String random(int length, CodeType type) {
		return random(length, getSource(type));
	}

	/**
	 * 获取指定长度的随机码，随机码由数字、小写字母、大写字母构成
	 * 
	 * @param length
	 * @return
	 */
	public static String random(int length) {
		return random(length, CodeType.AllMix);
	}

	private static String getSource(CodeType type) {
		switch (type) {
		case Numeric:
			return numeric;
		case LowerCase:
			return lowerCase;
		case UpperCase:
			return upperCase;
		case NumericAndLowerCase:
			return numeric + lowerCase;
		case NumericAndUpperCase:
			return numeric + upperCase;
		case AllMix:
			return numeric + lowerCase + upperCase;
		default:
			return null;
		}
	}

	/**
	 * 随机码类型
	 * 
	 * @author wnb
	 *
	 */
	public enum CodeType {
		/**
		 * 数字
		 */
		Numeric,
		/**
		 * 小写字母
		 */
		LowerCase,
		/**
		 * 大写字母
		 */
		UpperCase,
		/**
		 * 数字+小写字母
		 */
		NumericAndLowerCase,
		/**
		 * 数字+大写字母
		 */
		NumericAndUpperCase,
		/**
		 * 数字+小写字母+大写字母
		 */
		AllMix
	}
}
