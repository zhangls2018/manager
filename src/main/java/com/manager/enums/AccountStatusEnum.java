package com.manager.enums;

public enum AccountStatusEnum {

	valid("1","有效的"),
	frozen("2","已冻结")
	;
	
	AccountStatusEnum(String code,String remark){
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
