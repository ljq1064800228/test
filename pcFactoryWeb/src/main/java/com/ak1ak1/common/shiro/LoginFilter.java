package com.ak1ak1.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

//登陆拦截工具类
/*所有的filter拦截器都继承此类,
     是检查当前用户是否能执行访问的controller action的初步授权模式*/
public class LoginFilter extends AccessControlFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1) throws Exception {
		return false;
	}
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if(subject == null){
			return false;
		}
		//HttpSession session = WebUtils.toHttp(request).getSession();		
		return super.preHandle(request, response);
	}

}
