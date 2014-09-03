package com.yy.webservice.client;

import java.util.Properties;

public class AddressConfig {

	//private static AddressConfig addressConfig = new AddressConfig();
	// 属�?文件   
	private static final Properties prop = new Properties();  

	private AddressConfig(){
		
	}
	
/*	public static AddressConfig getAddressConfig(){
		return addressConfig ;
	}*/
	
	public static Properties getUrls(){
		return prop ;
	}
	
	public static String getUrlByKey(String key){
		return prop.getProperty(key);
	}

	//http://localhost:8080/ws_spring1/services/Face.FaceHttpSoap11Endpoint

}
