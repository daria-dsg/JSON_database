package client;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import server.model.Request;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        Request cla  = new Request();

        // Parse the command-line arguments
        JCommander.newBuilder()
                .addObject(cla)
                .build()
                .parse(args);

        String request = new Gson().toJson(cla);

        try (
             Socket socket = new Socket("localhost", 9999);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            output.writeUTF(request); //sent request to server
            System.out.println("Sent: " + request);
            System.out.println("Received: " + input.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


