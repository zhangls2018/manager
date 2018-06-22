package com.manager.entity;

import java.io.Serializable;

/**
 * 
 * @author 自动生成
 * @date 2018-6-20 20:49
 */
public class TSAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	/**人员基本信息表 _主键*/
	private String userId;
	
	/**用户名*/
	private String name;
	
	/**密码*/
	private String password;
	
	/**状态*/
	private String status;
	
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}

}