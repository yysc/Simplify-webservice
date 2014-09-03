package com.yy.webservice.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class LocalUrlLoader implements ServletContextListener {
	private static Logger logger = Logger.getLogger(LocalUrlLoader.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("contextDestroyed!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// 获取servlet上下文的绝对路径 
		String path = servletContextEvent.getServletContext().getRealPath("\\");     
		FileInputStream fis = null ;
		try {
		// 把文件读入文件输入流，存入内存中     
			fis = new FileInputStream(new File(path + "WEB-INF/classes/urls.properties"));     
		//加载文件流的属�?     
			AddressConfig.getUrls().load(fis);
			
			
		} catch (FileNotFoundException e) {
			logger.debug("The file: urls.properties is not found!");
			logger.debug("The Error message is :"+ e.getMessage() );
		} catch (IOException e) {
			logger.debug("failed to load file: urls.properties !");
			logger.debug("The Error message is :"+ e.getMessage() );
		} finally{
			if( fis!=null ){
				try {
					fis.close();
				} catch (IOException e) {
					logger.debug("failed to close FileInputStream when load file: urls.properties !");
				}
			}
		}
		
	}

}
