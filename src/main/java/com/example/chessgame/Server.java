package com.example.chessgame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public boolean connessione;

    void handshaking(int porta) throws IOException {
        ServerSocket serverSocket = new ServerSocket(porta);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                // Chiude il server socket
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        Socket socket = serverSocket.accept();

        Thread thread = new Thread(() -> {
            try (// Legge la richiesta dal client
                InputStream input = socket.getInputStream()) {
                byte[] bytes = new byte[input.available()];
                input.read(bytes);
                String request = new String(bytes);

                // Esegue la richiesta
                String response = "";
                if (request.equals("conversione")) {
                    // Converte una stringa in maiuscolo
                    response = request.toUpperCase();
                }

                // Invia la risposta al client
                OutputStream output = socket.getOutputStream();
                output.write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Chiude il socket
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        thread.start();
    }

}
