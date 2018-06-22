package com.manager.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.google.common.collect.Lists;
import com.manager.entity.TSAuthorityMenu;
import com.manager.service.MenuService;
import com.manager.vo.LoginUser;


public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	public final static String session_user_key = "user";
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Autowired
	private MenuService menuService;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if(!uri.startsWith("/login")){
			Object sessionUser = request.getSession().getAttribute(session_user_key);
			if(sessionUser == null){
				response.sendRedirect("/login");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String contextPath = request.getContextPath();
		if(StringUtils.isBlank(contextPath)){
			if(request.getServerPort()==80 || request.getServerPort()==443){
				contextPath = request.getScheme()+"://"+request.getServerName()+request.getContextPath();
			}else{
				contextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			}
		}
		freeMarkerConfigurer.getConfiguration().setSharedVariable("base", contextPath);
		
		if(!isAjaxRequest(request)){
			String uri = request.getRequestURI();
			if(!uri.startsWith("/login")){
				Object object = request.getSession().getAttribute(session_user_key);
				if(object != null){
					LoginUser loginUser = (LoginUser)object;
					boolean isAdmin = InitAdminService.isAdmin(loginUser.getActName());
					List<TSAuthorityMenu> menuList = Lists.newArrayList();
					if(isAdmin){
						menuList = menuService.listAll();
					}else{
						//角色权限菜单
						menuList = menuService.listByUserId(loginUser.getUserId());
					}
					modelAndView.addObject("menuList", menuList);
				}
			}
		}
	}
	
	private static boolean isAjaxRequest(HttpServletRequest request){
		String requestedWith=request.getHeader("x-requested-with");  
		if(StringUtils.isEmpty(requestedWith)){
			return false;
		}else if(StringUtils.isNotEmpty(requestedWith) && requestedWith.equals("XMLHttpRequest")){
			return true;
		}
		return false;
	}

}
