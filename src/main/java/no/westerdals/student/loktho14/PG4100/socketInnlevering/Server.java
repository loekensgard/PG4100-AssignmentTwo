package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.net.*;
import java.io.*;

public class Server extends Thread {
    private static boolean serverRunning = true;
    private Socket clientSocket;
    private static final int PORT = 5555;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Socket er laget");
            try {
                while (serverRunning) {
                    new Server(serverSocket.accept());
                }
            } catch (IOException e) {
                System.err.println("Klarte ikke ta imot client");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Kunne ikke lytte på port 5555");
            System.exit(1);
        } finally {
            try {
                System.out.println("Lukker connectionen");
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Klarte ikke lukke port 5555.");
                System.exit(1);
            }
        }
    }

    private Server(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run() {

        System.out.println("Ny client er koblet til");


        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);

                if (inputLine.equals("?")) {
                    inputLine = new String("\"Nei\" ends Client, ");
                }
                out.println(inputLine);
                out.flush();

                if (inputLine.toLowerCase().equals("nei")) {
                    break;
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problem med sending av tekst");
            System.exit(1);
        }
    }
}