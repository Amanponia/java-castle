

import java.io.*;
import java.net.*;
class Client {
	// step 2 : Client class to send msg to server
public static void main(String argv[]) throws Exception
{
String sentence;

BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
Socket clientSocket = new Socket("localhost", 6919);
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

System.out.println("enter a message for server");
sentence = inFromUser.readLine();
outToServer.writeBytes(sentence + '\n');

clientSocket.close();
}
}
