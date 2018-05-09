package org.iii.www;

public enum DB_Type implements IDB_type{
	Mysql{
		@Override
		public String getDB_Name() {			
			return "com.mysql.jdbc.Driver";
		}
		@Override
		public String getDB_Url(String db,String name,String password) {
			String connectionUrl = String.format("jdbc:mysql://localhost/%s?" +
                                   "user=%s&password=%s", db,name,password);
			return connectionUrl;
		}
		
	},
	MSsql{
		@Override
		public String getDB_Name() {			
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		}
		@Override
		public String getDB_Url(String db,String name,String password) {
			String connectionUrl= String.format("jdbc:sqlserver://localhost:1433;" +  
					   "databaseName=%s;user=%s;password=%s;", db,name,password);
			
			return connectionUrl;
		}
	},
	Oracle{
		@Override
		public String getDB_Name() {			
			return "oracle.jdbc.driver.OracleDriver";
		}

		@Override
		public String getDB_Url(String db,String name,String password) {
			return null;
		}
	};
}
interface IDB_type {
	public String getDB_Name();
	public String getDB_Url(String db,String name,String password);
}
