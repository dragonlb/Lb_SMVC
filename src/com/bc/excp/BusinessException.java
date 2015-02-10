package com.bc.excp;

import java.util.HashMap;
import java.util.Map;

import com.bc.enu.EnuRespCode;
import com.google.gson.Gson;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errCode;
	private String errMsg;
	private Map<String, Object> attachMap = new HashMap<String, Object>();
	
	public BusinessException(){ 
		super(); 
	} 
		
	public BusinessException (String code){ 
		super(code);
		this.setErrCode(code);
	}
	
	public BusinessException (EnuRespCode enumRespCode){ 
		super(enumRespCode.getCode());
		this.setErrCode(enumRespCode.getCode());
		this.setErrMsg(enumRespCode.getMsg());
	}

	public BusinessException attach(String key, Object val){
		this.getAttachMap().put(key, val);
		return this;
	}
	
	public String attachMapToString(){
		if(this.getAttachMap()==null || this.getAttachMap().keySet().size()<=0){
			return "";
		}
		Gson gson = new Gson();
		return gson.toJson(this.getAttachMap());
	}
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Map<String, Object> getAttachMap() {
		return attachMap;
	}

	public void setAttachMap(Map<String, Object> attachMap) {
		this.attachMap = attachMap;
	}
	
}