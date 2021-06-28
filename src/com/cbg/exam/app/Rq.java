package com.cbg.exam.app;

public class Rq {
	
	private String command;
	private String controllerTypeName;
	private String controllerName;
	private String methodName;
	private String queryString;
// /usr/article/list?
	public Rq(String command) {
		this.command = command;
		String[] commandBit = command.split("\\?", 2);
		
		if(commandBit.length == 1) {
			queryString = "";
		}else {
			queryString = commandBit[1];
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

}
