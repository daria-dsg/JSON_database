package server;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import server.command.*;
import server.database.DataBase;
import server.model.Request;
import server.model.Response;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server started!");
            DataBase database = DataBase.getInstance();

            while(true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    Controller controller = new Controller();

                    //Deserialization of JSON request from client
                    Request request = new Gson().fromJson(input.readUTF(), Request.class);
                    Response response = new Response();

                    try {
                        switch(request.getType()) {
                            case "get":
                                GetCommand getCmd = new GetCommand(request.getKey());
                                controller.executeCommand(getCmd);
                                response.setResponse("OK");
                                response.setValue(getCmd.getResult());
                                break;
                            case "set":
                                SetCommand setCmd = new SetCommand(request.getKey(), request.getValue());
                                controller.executeCommand(setCmd);
                                response.setResponse("OK");
                                break;
                            case "delete":
                                DeleteCommand deleteCmd = new DeleteCommand(request.getKey());
                                controller.executeCommand(deleteCmd);
                                response.setResponse("OK");
                                break;
                            case "exit":
                                response.setResponse("OK");
                                return;
                        }
                    } catch (RuntimeException e) {
                        response.setResponse("ERROR");
                        response.setReason("No such key");
                    }

                    output.writeUTF(new Gson().toJson(response));
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