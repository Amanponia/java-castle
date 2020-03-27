package JDBC ;
//step 1 - import package
import java.sql.*;
public class FetchData {
	 
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
		   
		  // step 4 - STATEMENT
		   
		 //  Use this for general-purpose access to your database. Useful when you are using static SQL statements at runtime. The Statement interface cannot accept parameters.
		   Statement stmt = con.createStatement();
		   
		   String sql_query = "SELECT * FROM studentlog" ; // STUDENT is table name
		   
		   // step 5 - RESULT_SET
		   
		   ResultSet rs = stmt.executeQuery(sql_query);
		   
		   while(rs.next()) {
			   
			 String Name = rs.getString("name");  
			 String Roll_no = rs.getString("roll_no");
			 
			 System.out.println("Student name :" + Name +"  Roll no :" +Roll_no );
			 
			 
			 
			 
			 
			   
		   }
		   
		   System.out.println("all data is fetched");
		   // step 6 - CLOSE
		   rs.close();
		   stmt.close();
		   con.close();
		   
		   
		   
		   
	   }
	

}
