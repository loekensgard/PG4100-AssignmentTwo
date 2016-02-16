package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.net.*;
import java.io.*;

public class Server extends Thread {
    private static boolean serverRunning = true;
    private Socket clientSocket;
    private static final int PORT = 5555;
    private DataOutputStream out;
    private DataInputStream in;
    private final String START_QUESTION = "Velkommen til quiz\nFor å fortsette kan du trykke hvilken som helst knapp\nDersom du ønsker å avslutte skriver du nei(\"Any/nei\")";
    private final String CORRECT = "Det er riktig!\n";
    private final String WRONG = "Det er feil!\n";
    private final String CONTINUE = "Vil du fortsette?(\"ja/nei\")";


    private Server(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run(){
        try{
            System.out.println("Ny client er koblet til");
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());
            out.writeUTF(START_QUESTION);
            out.flush();

            while (true) {
                if (in.readUTF().toLowerCase().equals("nei")) {
                    break;
                }

                Quiz quiz = new Quiz();
                out.writeUTF("Hvem har skrevet boken: " + quiz.getQuestion());
                String inputLine = in.readUTF();


                System.out.println(inputLine);
                if (StringChecker.check(inputLine, quiz.getAnswer())) {
                    out.writeUTF(CORRECT);
                } else {
                    out.writeUTF(WRONG + "Riktig svar er: " + quiz.getAnswer());
                }
                out.writeUTF(CONTINUE);
                out.flush();


            }

        }catch (Exception e){
            System.out.println("Problem med sending av text");
            System.exit(1);
        }

    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Socket er laget");
                while (serverRunning) {
                    new Server(serverSocket.accept());
                }
        } catch (IOException e) {
            System.err.println("Klarte ikke lytte på port " + PORT + " eller det var et problem med motagelsen av en klient");
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

}