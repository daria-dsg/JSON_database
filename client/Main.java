package client;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        //define class to hold arguments values
        class CommandLineArgs {

        }
        CommandLineArgs cli  = new CommandLineArgs();

        // Parse the command-line arguments
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        //build message to sent to server
        String msg = buildMsg(arguments.type, arguments.idOfCell, arguments.message);

        try (
             Socket socket = new Socket("localhost", 9999);
             DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            output.writeUTF(msg); //sent message to server
            System.out.println("Sent: " + msg);

            String reply = input.readUTF();
            System.out.println("Received: " + reply);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String buildMsg(String type, int index, String message) {
        String msg = type;

        if (index > 0) {
            msg += " " + index;
        }
        if (message != null) {
            msg += " " + message;
        }

        return msg;
    }
}


