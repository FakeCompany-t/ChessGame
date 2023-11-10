package com.example.chessgame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    void handshaking(String host, int porta) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost", porta);
        OutputStream output = socket.getOutputStream();
        output.write("conversione".getBytes());

        // Ricevi dal server una risposta
        InputStream input = socket.getInputStream();
        byte[] bytes = new byte[1024];
        input.read(bytes);

        // Stampa la risposta del server
        System.out.println(new String(bytes));

        // Chiude il socket
        socket.close();
    }

}
