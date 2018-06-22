package com.manager.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 自动生成
 * @date 2018-6-20 20:49
 */
public class TSAuthorityMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	/**菜单名称*/
	private String name;
	
	/**所属菜单*/
	private String parentId;
	
	/**菜单图标*/
	private String icon;
	
	/**菜单url*/
	private String url;
	
	/**菜单类型（1：菜单类型、2：访问类型）*/
	private String type;
	
	/**排序  升序*/
	private Integer sort;
	
	
	//---------------页面使用属性---分割线---------------------
	private List<TSAuthorityMenu> children;
	
	
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
	
	public String getParentId(){
		return parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	
	public String getIcon(){
		return icon;
	}
	
	public void setIcon(String icon){
		this.icon = icon;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<TSAuthorityMenu> getChildren() {
		return children;
	}

	public void setChildren(List<TSAuthorityMenu> children) {
		this.children = children;
	}

}