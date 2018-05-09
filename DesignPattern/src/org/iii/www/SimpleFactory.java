package org.iii.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SimpleFactory {
	
	public static void main(String[] args) {
		
		try {
			SimpleFactory.getConn(DB_Type.Mysql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	
	public static Connection getConn(DB_Type db) throws Exception {
		//使用列舉傳入DataBase的名稱
		Connection conn =null;
		switch(db) {
		case Mysql: Class.forName(DB_Type.Mysql.getDB_Name());
					conn= DriverManager.getConnection(DB_Type.Mysql.getDB_Url("stock", "root", "root"));
					break;
		case MSsql: Class.forName(DB_Type.MSsql.getDB_Name());
					conn= DriverManager.getConnection(DB_Type.MSsql.getDB_Url("stock", "root", "root"));
					break;
		case Oracle:Class.forName(DB_Type.Oracle.getDB_Name());
					String url = "jdbc:oracle:thin:@192.168.0.1:1521:stock";    
			        String user = "root";
			        String password = "root";
			        conn = DriverManager.getConnection(url, user, password);					
					break;
		}
		return conn;
		
	}

}
