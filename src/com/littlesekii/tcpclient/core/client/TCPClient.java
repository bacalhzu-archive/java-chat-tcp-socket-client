package com.littlesekii.tcpclient.core.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.littlesekii.tcpdata.TCPTransferDataExample;

public class TCPClient {
    
    private Socket clientSocket;

    public TCPClient(String serverHost, int serverPort) throws Exception {
        clientSocket = new Socket(serverHost, serverPort);

        ObjectOutputStream outputBuffer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inputBuffer = new ObjectInputStream(clientSocket.getInputStream());

        
        while (true) {
            
            System.out.print("Digite um texto em caixa baixa: ");            
            Scanner sc = new Scanner(System.in);
            String text = sc.nextLine();
            sc.reset();

            TCPTransferDataExample data = new TCPTransferDataExample();
            data.setData(text);

            outputBuffer.writeObject(data);
            outputBuffer.flush();

            text = ((TCPTransferDataExample) inputBuffer.readObject()).getData();
            System.out.println("Seu texto em caixa alta: " + text);
        }

    }
}
