package com.cbg.exam.app;

import java.util.HashMap;
import java.util.Map;

public class Rq {
	
	private String command;
	private String controllerTypeName;
	private String controllerName;
	private String methodName;
	private String queryString = "";
	private Map<String, String> params;
// /usr/article/list?
	public Rq(String command) {
		this.command = command;
		String[] commandBit = command.split("\\?", 2);
		
		if(commandBit.length == 2) {
			queryString = commandBit[1];
			
			params = new HashMap<>();
			
			String[] queryStringBits = queryString.split("&");
			for(String queryStringBit : queryStringBits) {
				String[]queryStringBitBits = queryStringBit.split("=", 2);
				String paramName = queryStringBitBits[0];
				String paramValue = queryStringBitBits[1];
				
				params.put(paramName, paramValue);
			}
		}
		
		String cmdBits = commandBit[0];
		
		String[] commandBitBits = cmdBits.split("/", 4);
		
		if(commandBitBits.length != 4) {
			System.out.println("올바른 명령어를 입력해주세요.");
			return;
		}
		
		controllerTypeName = commandBitBits[1];
		controllerName = commandBitBits[2];
		methodName = commandBitBits[3];
		
	}

	
	public String getActionPath() {
		return "/" + controllerTypeName + "/" + controllerName + "/" + methodName;
	}


	public int getIntParam(String paramName, int defaultValue) {
		if(params.containsKey(paramName) == false) {
			return defaultValue;
		}
		
		try {
			return Integer.parseInt(params.get(paramName));
		}catch(NumberFormatException e) {
			return defaultValue;
		}
		
		
	}


	

}
