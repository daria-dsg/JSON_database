package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        CommandLineArgs cla  = new CommandLineArgs();

        // Parse the command-line arguments
        JCommander.newBuilder()
                .addObject(cla)
                .build()
                .parse(args);

        String request = new Gson().toJson(cla);
        System.out.println(request);

//        try (
//             Socket socket = new Socket("localhost", 9999);
//             DataInputStream input = new DataInputStream(socket.getInputStream());
//             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
//        ) {
//            System.out.println("Client started!");
//            output.writeUTF(msg); //sent message to server
//            System.out.println("Sent: " + msg);
//
//            String reply = input.readUTF();
//            System.out.println("Received: " + reply);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}


