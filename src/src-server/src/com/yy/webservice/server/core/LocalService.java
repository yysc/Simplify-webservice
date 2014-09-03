package com.yy.webservice.server.core;

import org.apache.axis2.AxisFault;
import org.apache.axis2.ServiceObjectSupplier;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.Parameter;
import org.apache.axis2.i18n.Messages;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class LocalService implements ServiceObjectSupplier, ApplicationContextAware  {
	private static ApplicationContext ctx;
	
	//被发布的WebService程序调用
	public final String execute(String params, String token){
		if( validate(token) ){
			return invoke(params) ;
		}else{
			//TODO token验证没有通过,返回�?��值告知客户端??
			return null ;
		}
	}
	
	//进行token验证
	public boolean validate(String token){
		return true ; 
	}
	
	//业务方法
	private String invoke(String params){
		BaseService baseService = (BaseService) ctx.getBean("BaseService");
		return baseService.invoke(params);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		LocalService.ctx = ctx;
		
	}

	@Override
	public Object getServiceObject(AxisService axisService) throws AxisFault {
	       Parameter springBeanName = axisService.getParameter("SpringBeanName");
	        String beanName = ((String) springBeanName.getValue()).trim();
	        if (beanName != null) {
	            if (ctx == null)
	                throw new AxisFault("applicationContext is NULL! ");
	            if (ctx.getBean(beanName) == null)
	                throw new AxisFault("Axis2 Can't find Spring Bean: " + beanName);
	            return ctx.getBean(beanName);
	        } else {
	            throw new AxisFault(Messages.getMessage("paramIsNotSpecified",
	                    "SERVICE_SPRING_BEANNAME"));
	        }

	}
}
