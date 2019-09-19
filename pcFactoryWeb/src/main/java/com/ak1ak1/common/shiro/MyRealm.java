package com.ak1ak1.common.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.ak1ak1.entity.User;
import com.ak1ak1.service.UserServer;

//验证工具类
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserServer userServer;
	
	//权限验证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	//身份验证（登陆验证）
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String userName = usernamePasswordToken.getUsername();
        User user = userServer.getUsersByUserName(userName);
        if(user == null){
        	throw new UnknownAccountException();
        }
        // 密码匹配
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(),getName());
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return info;
	}
} 
