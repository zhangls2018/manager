package com.manager.controller;

import org.apache.commons.lang3.StringUtils;

import com.manager.result.BResult;
import com.manager.result.ResultCodeEnum;

public class BaseController {
	
	public BResult success(Object data){
		BResult result = new BResult();
		result.setData(data);
		return result;
	}
	
	public BResult success(){
		return new BResult();
	}
	
	public BResult result(boolean isSuc) {
		if(isSuc){
			return success();
		}else{
			return error("操作失败");
		}
	}

	public BResult error(String msg) {
		BResult result = new BResult();
		result.setCode(ResultCodeEnum.SYS_ERROR.getCode());
		result.setMsg(msg);
		return result;
	}

	public BResult exception(Exception e) {
		e.printStackTrace();
		BResult result = new BResult();
		result.setCode(ResultCodeEnum.SYS_ERROR.getCode());
		result.setMsg(e.getMessage());
		return result;
	}
	
	public BResult exception(Exception e,String returnMsg) {
		if(StringUtils.isBlank(returnMsg)){
			return exception(e);
		}
		BResult result = new BResult();
		result.setCode(ResultCodeEnum.SYS_ERROR.getCode());
		result.setMsg(returnMsg);
		return result;
	}

}
