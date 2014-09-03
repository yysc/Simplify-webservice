package com.edatongtu.webservice.core;

public class HelloWorld implements BaseService {
	
	// params 是客户端调用时发过来的json串
	@Override
	public String invoke(String params) {
		System.out.println("hello:"+params);
		return params;
	}

}
