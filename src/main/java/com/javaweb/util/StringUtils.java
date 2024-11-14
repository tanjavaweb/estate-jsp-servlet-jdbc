package com.javaweb.util;

public class StringUtils {

	public static boolean isNullOrEmpty(String value) {
		if (value != null && !value.isEmpty() && value != "") {
			return false;
		}
		return true;
	}
}
