package com.zyt;

public interface Const {
	interface PackageName {
		String ENTITY = "com.zyt.entity";
	}

	interface Druid{
		String STAT="stat";
	}

	interface Props {
		String DIALECT = "dialect";
		interface JDBC {
			String USERNAME = "jdbc.username";
			String PASS = "jdbc.password";
			String URL = "jdbc.url";
		}
	}

	interface Coding {
		String UTF8 = "utf-8";
	}
	
	interface Login{
		String USERNAME="username";
		String PASSWORD="password";
	}
	
}
