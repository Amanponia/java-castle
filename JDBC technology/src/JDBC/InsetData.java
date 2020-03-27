package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsetData {
	   static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	   // DATABASE_NAME = name of database from you fetch data
	   static final String url = "jdbc:mysql://localhost:3306/student" ;
	   // your mysql login details
	   static final String user_name = "root";
	   static final String user_pass = "ponia@2812";
	   
	   public static void main(String args[]) throws ClassNotFoundException, SQLException {
		   // step 2 - LOAD DRIVER
		    
		   Class.forName(JDBC_Driver);
		   
		   System.out.println("connecting to database ..");
		   
		   // step 3 - CONNECTION
		   
		   Connection con = DriverManager.getConnection(url,user_name,user_pass);
		   String sql_query = "insert into studentlog values(?,?)";
		   
		   
		   // The PreparedStatement interface accepts input parameters at runtime.
		   PreparedStatement stmt = con.prepareStatement(sql_query);
		    String name = "shaurya";
		     int roll_no = 6;
		   stmt.setString(1, name);
		    stmt.setInt(2, roll_no);
		   stmt.executeUpdate();
		   
		   System.out.println("Data is pushed into table");
		   
		   stmt.close();
		   con.close();
		   
		   
		   
	   }

}
