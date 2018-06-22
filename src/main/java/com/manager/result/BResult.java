package com.manager.result;

public class BResult {

	private Integer code = ResultCodeEnum.OK.getCode();
	
	private Object data;
	
	private String msg;
	
	public BResult(){}
	
	public BResult(Integer code,String message){
		this.code = code;
		this.msg = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
