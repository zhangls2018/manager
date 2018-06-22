package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entity.TSAccount;
import com.manager.enums.AccountStatusEnum;
import com.manager.mapper.TSAccountMapper;
import com.manager.util.Tools;
import com.manager.vo.LoginUser;

@Service
public class TSAccountService{
	
	@Autowired
	private TSAccountMapper tSAccountMapper;

	public LoginUser login(String loginName,String password) throws Exception{
		TSAccount tsAccount = tSAccountMapper.getByName(loginName);
		if(tsAccount == null){
			throw new Exception("账号不存在");
		}
		String hexPassword = Tools.hexPassword(password);
		if(!hexPassword.equals(tsAccount.getPassword())){
			throw new Exception("账号或密码不正确");
		}
		if(AccountStatusEnum.frozen.getCode().equals(tsAccount.getStatus())){
			throw new Exception("账号已被冻结");
		}
		return buildLoginUser(tsAccount);
	}
	
	private LoginUser buildLoginUser(TSAccount tsAccount){
		LoginUser loginUser = new LoginUser();
		loginUser.setActId(tsAccount.getId());
		loginUser.setActName(tsAccount.getName());
		
		return loginUser;
	}
}
