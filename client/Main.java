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
        class Arguments {
            @Parameter( names = "-t", required = true)
            String typeOfRequest;

            @Parameter (names = "-i")
            int idOfCell;

            @Parameter( names = "-m")
            String message;

        }
        Arguments arguments  = new Arguments();

        // Parse the command-line arguments
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        System.out.println(arguments.typeOfRequest);
        System.out.println(arguments.idOfCell);
        System.out.println(arguments.message);

    }
}
//        try (
//             Socket socket = new Socket("localhost", 9999);
//             DataInputStream input = new DataInputStream(socket.getInputStream());
//             DataOutputStream output = new DataOutputStream(socket.getOutputStream())
//        ) {
//            System.out.println("Client started!");
//            String msg = "Give me a record # 12";
//            output.writeUTF(msg); //sent message to server
//            System.out.println("Sent: " + msg);
//
//            String reply = input.readUTF();
//            System.out.println("Received: " + reply);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

