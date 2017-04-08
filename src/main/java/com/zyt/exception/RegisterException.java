package com.zyt.exception;

public class RegisterException extends RuntimeException {
	private static final long serialVersionUID = -3900337532912399917L;
	public RegisterException(){
		super();
	}
	public RegisterException(Throwable e){
		super(e);
	}
}
