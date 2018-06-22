package com.manager.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.config.GlobalInterceptor;
import com.manager.result.BResult;
import com.manager.service.TSAccountService;
import com.manager.vo.LoginUser;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{
	
	@Autowired
	private TSAccountService tsAccountService;

	@RequestMapping("")
	public String login(){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("validate")
	public BResult validate(String loginName,String password,HttpSession session){
		try {
			if(StringUtils.isBlank(loginName)){
				return super.error("用户名不能为空");
			}
			if(StringUtils.isBlank(password)){
				return super.error("密码不能为空");
			}
			LoginUser loginUser = tsAccountService.login(loginName, password);
			session.setAttribute(GlobalInterceptor.session_user_key, loginUser);
			return super.success();
		} catch (Exception e) {
			return super.exception(e);
		}
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public void logout(HttpSession session){
		session.removeAttribute(GlobalInterceptor.session_user_key);
	}
}
