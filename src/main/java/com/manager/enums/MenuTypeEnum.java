package com.manager.enums;

public enum MenuTypeEnum {

	menu("1","菜单文件夹"),
	link("2","菜单访问项");
	
	MenuTypeEnum(String code,String remark){
		this.code = code;
		this.remark = remark;
	}
	
	private String code;
	
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
