package server;

import com.google.gson.JsonObject;
import server.command.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server started!");
            JsonObject database = DataBase.getInstance();

            while(true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                     Controller controller = new Controller();

                     String request = input.readUTF(); //read request from client
                     String[] parts = reply.split("\\s+", 3);

                     // Extract the command and arguments
                     String command = parts[0];
                     int number = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
                     String message = parts.length > 2 ? parts[2] : null;
                     String msg = null;

                     switch(command) {
                        case "get":
                            controller.setCommand(new GetCell(database));
                            msg = controller.executeCommand(number);
                            break;
                        case "set":
                            controller.setCommand(new SetCell(database));
                            msg = controller.executeCommand(number, message);
                            break;
                        case "delete":
                            controller.setCommand(new DeleteCell(database));
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
