package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Thorstein on 15.02.2016.
 */
public class Server {
    private final int port = 5632;

    public Server(){
        try{
            ServerSocket serverConnection = new ServerSocket(port);
            while(true){
                Socket socket = serverConnection.accept();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        new Server();
    }

}
