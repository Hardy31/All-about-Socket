package ru.hardy;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8081);

        Socket inputSocket = serverSocket.accept();
        Scanner in  = new Scanner(inputSocket.getInputStream());
        while (in.hasNext()){
            System.out.println(in.nextLine());
        }
        in.close();
        inputSocket.close();
        serverSocket.close();
    }




}
