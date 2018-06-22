package com.manager.result;

public enum ResultCodeEnum {
	
	OK(200,"正常"),
	NEED_LOGIN(403,"回话已过期，请先登录"),
	SYS_ERROR(500,"系统异常");
	
	ResultCodeEnum(Integer code,String remark){
		this.code = code;
		this.remark = remark;
	}
	
	private Integer code;
	
	private String remark;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
