package com.bc.excp;

/**
 * 交互超时异常
 * @author Lb
 */
public class BcTransactTimeOutException extends Exception {
	
	private static final long serialVersionUID = 6203519956821622230L;

	public BcTransactTimeOutException(){ 
		super(); 
	} 
		
	public BcTransactTimeOutException (String msg){ 
		super(msg); 
	} 

}
