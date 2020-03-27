




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*; 

/* step 1 - MYsql : create database "Student" and table data . inside table two column "rollno " & "name"
step 2 - create class Client : who send a Name of student to store on server database
step 3 - create Server class : who accept client req and fetch msg and stored in database using JDBC */


class Server{ public static void  main(String args[]) throws IOException
{
	String clientSentence;
	
	ServerSocket WelcomeSocket = new ServerSocket(6919);    // Server socket 
	while(true) {
	Socket connectionSocket = WelcomeSocket.accept();
	BufferedReader inFromClient =
	new BufferedReader(new
	InputStreamReader(connectionSocket.getInputStream()));


	clientSentence = inFromClient.readLine(); 
	int rollno=4; // read client message
	 
	Server obj = new Server(rollno,clientSentence); // call server constructor
	
	}
}

	


Server(int rollno ,String msg ){  // JDBC for storing message into database
	try{  
		
		Class.forName("com.mysql.jdbc.Driver");  
		//here student is database name, root is username and password  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/student","root","ponia@2812"); 
		
		// prepared statement for storing data 

		PreparedStatement stmt=con.prepareStatement("insert into data values(?,?)");  
		stmt.setInt(1,rollno);//1 specifies the first parameter in the query  
		stmt.setString(2, msg);  
		rollno ++;
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		
		//  Statement for show table  updated

		Statement stmtt=con.createStatement();  
		ResultSet rs=stmtt.executeQuery("select * from data");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  ");  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
}

