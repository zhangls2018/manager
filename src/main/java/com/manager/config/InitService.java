package com.manager.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitService {
	
	@Autowired
	private InitAdminService initAdmin;
	
	@PostConstruct
	public void init() throws Exception{
		initAdmin.init();
	}
	
}
