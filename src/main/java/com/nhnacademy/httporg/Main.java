package com.nhnacademy.httporg;

import com.nhnacademy.httporg.request.Request;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket()) {
            InetSocketAddress address = new InetSocketAddress(80);
            serverSocket.bind(address);

            Socket socket = serverSocket.accept();

            String ip=(((InetSocketAddress) socket.getRemoteSocketAddress()).getAddress()).toString().replace("/","");
            System.out.println(ip);

            Request request = new Request(socket);
            request.getRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
