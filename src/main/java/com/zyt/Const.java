package com.zyt;

public interface Const {
	interface Attr {
		interface Login {
			String USERNAME = "username";
			String PASSWORD = "password";
		}
		String LOGIN_USER="login_user";
	}

	interface PackageName {
		String ENTITY = "com.zyt.entity";
	}

	interface Druid {
		String STAT = "stat";
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

}
