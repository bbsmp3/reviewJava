package com.cib.mytest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDateSuffix = dateformat.format(date);
		System.out.println(sDateSuffix);

	}

}
