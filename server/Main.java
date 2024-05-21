package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.command.*;
import server.database.DataBase;
import server.model.Request;

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

                    //JSON request from client deserialization
                    Request request = new Gson().fromJson(input.readUTF(), Request.class);

                     switch(request.getType()) {
                        case "get":
                            GetCommand getCmd = new GetCommand(request.getKey());
                            controller.executeCommand(getCmd);

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
