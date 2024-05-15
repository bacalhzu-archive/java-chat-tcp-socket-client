package com.littlesekii.tcpclient;

import com.littlesekii.tcpclient.core.client.TCPClient;

public class App {
    public static void main(String[] args) throws Exception {
        new TCPClient("127.0.0.1", 1001);
    }
}
