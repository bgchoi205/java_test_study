package com.cbg.exam.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ut {

	public String getNow(){
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		return format_time1;
	}
}
