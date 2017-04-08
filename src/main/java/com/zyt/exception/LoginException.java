package com.zyt.exception;

public class LoginException extends RuntimeException {
	private static final long serialVersionUID = 6198593686026334880L;
	public LoginException(){
		super();
	}
	public LoginException(Throwable e){
		super(e);
	}
}
