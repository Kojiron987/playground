package myservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.InputStreamReader;

public class EchoServer {
    public static void run(String[] args) {
       if (args.length != 1)  {
           System.err.println("Usage: java Echoserver <port number>");
           System.exit(1);
       }

       int portNumber = Integer.parseInt(args[0]);

       try (
           ServerSocket serverSocket = new ServerSocket(portNumber);
           Socket clientSocket = serverSocket.accept();
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
           BufferedReader in = new BufferedReader(
               new InputStreamReader(clientSocket.getInputStream()));
           ) {
               String inputLine = null;
               while ((inputLine = in.readLine())!= null) {
                   out.println(inputLine);
               }
           } catch (IOException e) {
               System.out.println("Exception caught when trying to listen on "
                    + portNumber + " or listerning for a connection");
               System.out.println(e.getMessage());
           }
    }
}
