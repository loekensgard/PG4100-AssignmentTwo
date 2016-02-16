package no.westerdals.student.loktho14.PG4100.socketInnlevering;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Thorstein on 15.02.2016.
 */
public class Client {
    private final String ADRESSE = "localhost";
    private final int PORT = 5632;
    private boolean running = true;
    private final Scanner SCANNER = new Scanner(System.in);

    public Client(){
        try{

        Socket clientSocket = new Socket(ADRESSE, PORT);
        DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());


            while(running){
                if(SCANNER.hasNextLine()){
                    String text = SCANNER.nextLine();
                    outputStream.writeUTF(text);

                    if(text.toLowerCase().equals("nei")){
                        running = false;
                    }
                }
            }


            while(running) {
                System.out.println(inputStream.readUTF());
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        new Client();
    }

}
