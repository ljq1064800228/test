package com.ak1ak1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ak1ak1.common.utils.EncryptUtils;
import com.ak1ak1.entity.User;
import com.ak1ak1.service.UserServer;




/**
 * 登录
 * @author 肖建福
 *
 */
@Controller
@RequestMapping(value = "/")
public class UserController {
	
	@Resource
	private UserServer userServer;
	

	// 去到首页
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		// 判断session中是否存在用户信息
		if(user == null){
			return "login";
		}else{
			return "index";
		}
	}	
     
	// 登录
	@RequestMapping("/login")
	public ResponseEntity<?> login(String userName,String password,HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		// 获取当前的Subject
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName,EncryptUtils.getSHA256Str(password));
		token.setRememberMe(true);
		try {
			subject.login(token);
			Session session = subject.getSession();
			session.setAttribute("", "");
			map.put("success", true);
			map.put("msg", "登陆成功，欢迎回来！");
			return ResponseEntity.ok(map);
		} catch (UnknownAccountException e) {
			map.put("success", false);
			map.put("msg", "登陆失败，用户不存在！");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "登陆失败，密码错误！");
			return ResponseEntity.ok(map);
		}
	}
	
	// 退出登录
	@RequestMapping("/loginOut")
	public ResponseEntity<?> loginOut(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		try {
			request.getSession().removeAttribute("user");
			map.put("success", true);
			map.put("msg", "退出成功！");
			SecurityUtils.getSubject().logout();
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("msg", "退出失败！");
			return ResponseEntity.ok(map);
		}
	}	
	// 修改密码
	@RequestMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(HttpServletRequest request,String origPassword,String newPassword){
		Map<String, Object> map = new HashMap<>();
		User user = (User)request.getSession().getAttribute("user");
		if(user.getPassword().equals(EncryptUtils.getSHA256Str(origPassword))){
			try {
				User factory = new User();
				factory.setUserName(user.getUserName());
				factory.setPassword(EncryptUtils.getSHA256Str(newPassword));
				userServer.updatePassword(factory);
				// 删除域信息
				//request.getSession().removeAttribute("Company");
				map.put("success", true);
				map.put("msg", "密码修改成功，请重新登录！");
				request.getSession().removeAttribute("user");
				return ResponseEntity.ok(map);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("success", false);
				map.put("msg", "系统错误，密码修改失败！");
				return ResponseEntity.ok(map);
			}
		}else{
			map.put("success", false);
			map.put("msg", "旧密码输入错误！");
			return ResponseEntity.ok(map);
		}
	}
	
	
}
