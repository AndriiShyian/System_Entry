package com.softserve.ita.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

	public class DbConnector {
		     String url = "jdbc:mysql://127.0.0.1:3306/entry_system?UseSSL = false?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	         String pass = "";
	         String user = "root";
	         
		public DataSource getMySQLDataSource() {
			MysqlDataSource mysqlDS = null;
			
			try {
		
				mysqlDS = new MysqlDataSource();
				mysqlDS.setURL(url);
				mysqlDS.setUser(user);
				mysqlDS.setPassword(pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mysqlDS;
		}
}