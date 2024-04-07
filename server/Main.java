package server;

import server.command.*;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server started!");
            DataBase db = DataBase.getInstance();

            while(true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                     Controller controller = new Controller();

                     String reply = input.readUTF(); //read msg from client
                     String[] parts = reply.split("\\s+");

                     // Extract the command and arguments
                     String command = parts[0];
                     int number = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
                     String message = parts.length > 2 ? parts[2] : null;
                     String msg = null;

                     switch(command) {
                        case "get":
                            controller.setCommand(new GetCell(db));
                            msg = controller.executeCommand(number);
                            break;
                        case "set":
                            controller.setCommand(new SetCell(db));
                            msg = controller.executeCommand(number, message);
                            break;
                        case "delete":
                            controller.setCommand(new DeleteCell(db));
                            msg = controller.executeCommand(number);
                            break;
                         case "exit":
                             output.writeUTF("exit");
                             return;
                    }
                    output.writeUTF(msg);
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
