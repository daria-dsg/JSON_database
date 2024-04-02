package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try(
            ServerSocket serverSocket = new ServerSocket(9999)
        ) {
            System.out.println("Server started!");
            try (
                Socket socket = serverSocket.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String reply = input.readUTF();
                System.out.println("Received: " + reply);

                String msg = "A record # 12 was sent!";
                output.writeUTF(msg);
                System.out.println("Sent: " + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
