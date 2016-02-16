package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static String serverHost = "localhost";
    //private static PrintWriter out = null;
    //private static BufferedReader in = null;
    //private static BufferedReader stdIn;
    private static DataOutputStream out = null;
    private static DataInputStream in = null;
    private static Socket socket = null;
    private static boolean clientRunning = true;
    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        String serverHostname = serverHost;

        if (args.length > 0) {
            serverHostname = args[0];
        }

        System.out.println("Prøver å koble til host " +
                serverHostname + " on port 5555.");

        try {
            socket = new Socket(serverHostname, 5555);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            //out = new PrintWriter(socket.getOutputStream(), true);
            //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Finner ikke hosten: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Serveren er ikke oppe å kjører: " + serverHostname);
            System.exit(1);
        }


        String userInput;
        while (true) {
            System.out.println(in.readUTF());
            userInput = SCANNER.nextLine();
            out.writeUTF(userInput);
            out.flush();
            if (userInput.toLowerCase().equals("nei")) {
                break;
            }

            System.out.println(in.readUTF());
            userInput = SCANNER.nextLine();
            out.writeUTF(userInput);
            out.flush();
            System.out.println(in.readUTF());

        }

        out.close();
        in.close();
        socket.close();
    }
}