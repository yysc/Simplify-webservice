package com.yy.webservice.server;

import com.edatongtu.webservice.core.LocalService;


public class Face {
	private LocalService localService ;

	public void setLocalService(LocalService localService) {
		this.localService = localService;
	}

	public String invoke(String params, String token){
		//LocalService bs = new LocalService();
		
		return localService.execute(params, token);
		
	}

	
}
