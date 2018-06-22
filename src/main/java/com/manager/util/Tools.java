package com.manager.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class Tools {
	
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static String hexPassword(String password) throws Exception{
		if(StringUtils.isNotBlank(password)){
			return DigestUtils.md5Hex(password);
		}
		throw new Exception("密码不能为空");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(uuid());
	}

}
