package com.bc.db;

/**
 * 逻辑删除标志
 * @author Lb
 * @date 2014年10月8日
 */
public enum EnuIsDeleted {

	/** 默认-保留 */
	DEFAULT(0, "默认-保留"),
	/** 保留*/
	HOLD(1, "保留"),
	/** 已删除 */
	DELETED(2, "已删除");
	
	private int value;
	
	private String desp;
	
	EnuIsDeleted(int value, String desp){
		this.value = value;
		this.desp = desp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}
}
