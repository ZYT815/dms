package com.zyt;

public interface Const {
	interface PackageName{
		String ENTITY="com.zyt.entity";
	}
	interface Props{
		String DIALECT="dialect";
		interface JDBC{
			String USERNAME="jdbc.username";
			String PASS="jdbc.password";
			String URL="jdbc.url";
		}
	}
}
