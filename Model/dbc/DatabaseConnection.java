package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";  
    private static final String DBURL = "jdbc:mysql://100.64.11.43:3306";  
    private static final String DBuser = "movie";  
    private static final String DBPASSWORD = "1234";  
    private Connection conn = null;  
  
    public DatabaseConnection() throws Exception {  
        try {
        	Class.forName(DBDRIVER);// ������������  
        	conn = DriverManager.getConnection(DBURL, DBuser, DBPASSWORD);// �������ݿ�
        } catch (ClassNotFoundException e) {
			System.out.println("jdbc Driver cannot found.");
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			System.out.println("DB connection failed.");
			e.printStackTrace();
			throw e;
		}
    }  
  
    public Connection getConnection() { // ȡ�����ݿ�����  
        return this.conn;  
    }  
  
    public void close() throws Exception {  // ���ݿ�رղ���  
        if (this.conn != null) {  
            try {  
                this.conn.close();  
            } catch (Exception e) {  
                throw e;  
            }  
        }  
    }  

}

