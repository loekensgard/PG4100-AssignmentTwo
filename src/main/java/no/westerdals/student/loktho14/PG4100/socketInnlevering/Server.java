package no.westerdals.student.loktho14.PG4100.socketInnlevering;

import java.net.*;
import java.io.*;
import java.sql.SQLException;

public class Server extends Thread {
    private static boolean serverRunning = true;
    private Socket clientSocket;
    private static final int PORT = 5555;
    private PrintWriter out;
    private BufferedReader in;
    private final String START_QUESTION = "Velkommen til quiz vil du fortsette?(\"ja/nei\")";
    private final String CORRECT = "Det er riktig!\n";
    private final String WRONG = "Det er feil!\n";
    private final String CONTINUE = "Vil du fortsette?(\"ja/nei\")";


    private Server(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    public void run(){
        try{
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(START_QUESTION);

            while(true){
                Quiz quiz = new Quiz("root","9t09aras");

                out.println("Hvem har skrevet boken: " + quiz.getQuestion());
                String inputLine = in.readLine();

                if(inputLine.equals(quiz.getAnswer())){
                    out.println(CORRECT);
                }else{
                    out.println(WRONG + "Riktig svar er: " + quiz.getAnswer());
                }

                out.println(CONTINUE);

                if (inputLine.toLowerCase().equals("nei")) {
                    break;
                }
            }

        }catch (Exception e){
            System.out.println("Problem med sending av text");
            System.exit(1);
        }


        /*System.out.println("Ny client er koblet til");
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
        }*/
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