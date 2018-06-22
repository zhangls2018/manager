package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.entity.TSAuthorityMenu;
import com.manager.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;

	@RequestMapping("list")
	public String list(){
		return "menu/menu-list";
	}
	
	@RequestMapping("add")
	public String add(Model model){
		List<TSAuthorityMenu> list = menuService.listLv1();
		model.addAttribute("lv1MenuList",list);
		return "menu/menu-add";
	}
}
