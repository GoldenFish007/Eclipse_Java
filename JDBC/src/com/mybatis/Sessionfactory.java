package com.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Sessionfactory {

	public static SqlSessionFactory buildSqlSessionFactory() {
	  
		DataSource dataSource 
	      =  Sqldatasource.getMySQLDataSource();
		
	    Environment environment 
	      = new Environment("Development", new JdbcTransactionFactory(), dataSource);
	        
	    Configuration configuration = new Configuration(environment);
	    configuration.addMapper(Studentmapper.class);

	    SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(configuration);
	    return builder;
	}
}
