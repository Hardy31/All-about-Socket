package ru.hardy;

import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

public class ClientSocket {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8081) ;
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        out.println("Hello");
        out.println("How are you?");

        out.close();
        socket.close();


    }
}
