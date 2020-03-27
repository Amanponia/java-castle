package pss_server;


import java.io.*;
import java.net.*;

import java.util.*;

public class WebServer {
	public static void main(String args[])throws Exception
	{   //Defining 2 string objects
		String requestMessageLine;//It will contain the first line in the HTTP message 
		String fileName;//It will contain the file name of the requested file 
		//These are two socket like objects 
		ServerSocket listenSocket=new ServerSocket(9190);//It is created by the server program before receiving a request		
		Socket connectionSocket= listenSocket.accept();	//when the request arrives the accept method listen the socket and create a new object
		BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));//The http request comes from network through connectionsocket and into infromclient
		DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());// response message goes into outtoclient through socketconnection and into the network
		requestMessageLine=inFromClient.readLine();//IT reads the first line of the http request it takes input in the form of GET file_name HTTP/1.0
		
		//NOw our server will parse the line to extract the filename
		
		StringTokenizer tokenizedLine=new StringTokenizer(requestMessageLine);//The first line of request message to obtain the requested filename 
		
		if(tokenizedLine.nextToken().equals("GET")) {
		
			fileName=tokenizedLine.nextToken();
			if(fileName.startsWith("/")==true)
				fileName=fileName.substring(1);
			
			
			File file=new File(fileName);
			int numOfBytes=(int)file.length();
			FileInputStream inFile=new FileInputStream(fileName);//it attaches a stream infile 
			byte[] fileInBytes=new byte[numOfBytes];//it determine the size of the string
			inFile.read(fileInBytes);
					
		outToClient.writeBytes("HTTP/1.0 200 Document Follows");
		
		if(fileName.endsWith(".jpg"))
		
			outToClient.writeBytes("Content-Type: image/jpg\r\n");
		if(fileName.endsWith(".gif"))
			outToClient.writeBytes("Content-Type: image/gif\r\n");
		outToClient.writeBytes("Content-Length"+numOfBytes+ "\r\n");
			
		outToClient.writeBytes("\r\n");
		
		outToClient.write(fileInBytes,0,numOfBytes);
		
		connectionSocket.close();
		
		
			
		}
		else {
			System.out.println("Bad request Message");
		}
		listenSocket.close();
		
		
	}

}
