package com.ak1ak1.test;

import com.ak1ak1.common.utils.EncryptUtils;

public class Demo {

	public static void main(String[] args) {
		String sha256Str = EncryptUtils.getSHA256Str("123456");
		System.out.println(sha256Str);
	}
	
}
