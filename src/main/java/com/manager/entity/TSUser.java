package com.manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 自动生成
 * @date 2018-6-20 20:49
 */
public class TSUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	/**姓名*/
	private String name;
	
	/**性别*/
	private String sex;
	
	/**出生日期*/
	private Date birthday;
	
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

}