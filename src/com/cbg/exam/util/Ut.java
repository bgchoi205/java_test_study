package com.cbg.exam.util;

import java.text.SimpleDateFormat;

public class Ut {

	public String getNow(){
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		return format1.toString();
	}
}
