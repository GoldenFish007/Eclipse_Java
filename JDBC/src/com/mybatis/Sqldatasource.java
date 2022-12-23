package com.mybatis;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Sqldatasource {

	public static DataSource getMySQLDataSource() {

		MysqlDataSource mysql = null;
		
		
			mysql = new MysqlDataSource();
			mysql.setURL("jdbc:mysql://localhost:3306/db");
			mysql.setUser("tarapia");
			mysql.setPassword("TAPIOCA");
		
		return mysql;
	}
}
