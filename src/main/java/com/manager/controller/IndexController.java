package com.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController extends BaseController {

	@RequestMapping("")
	public String index(){
		return "index";
	}
}
