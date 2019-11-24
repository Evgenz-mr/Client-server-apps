package com.devcolibri.logpack;

import org.apache.log4j.Logger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;


class OrderLogic {
    // Initialization log
    static final Logger log = Logger.getLogger(OrderLogic.class);


    void doOrder(){
        // logging info
        // log.info(info);
        addToCart();
    }

    private void addToCart() {
        // logging error
        // log.error(error);
    }
}


class ReadIni extends OrderLogic {

    private int ports() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            return Integer.parseInt(p.getProperty("port"));
        } catch (IOException e) {
            System.out.println(e);
        }
        return Integer.parseInt(null);
    }

     static String username() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            return p.getProperty("username");
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }




    static class Server extends ReadIni {
        static OrderLogic logic;
        static String inf;

        // constructor with port
        Server(int port) {
            // starts server and waits for a connection
            try {
                ServerSocket server = new ServerSocket(port);
                System.out.println("Server started");
                log.warn("Server started");

                System.out.println("Waiting for a client ...");
                log.info("Waiting for a client ...");

                //initialize socket and input stream
                Socket socket = server.accept();
                System.out.println("Client " + username() + " accepted");
                log.info("Client " + username() + " accepted");

                // takes input from the client socket
                DataInputStream in = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));

                inf = "";


                // reads message from client until "quit" is sent
                while (!inf.equals("quit")) {
                    try {
                        inf = in.readUTF();
                        System.out.println(username() + ": " + inf);
                        log.info(username() + ": " + inf);

                    } catch (IOException i) {
                        System.out.println(i);
                        log.error(i);
                        break;
                    }
                }
                System.out.println("Closing connection");

                // close connection
                socket.close();
                in.close();
            } catch (IOException i) {
                System.out.println(i);
                log.error(i);
            }

        }

        public static void main(String args[]) {
            logic = new OrderLogic();
            ReadIni ini = new ReadIni();
            int port_srv = ini.ports();
            Server server = new Server(port_srv);
            logic.doOrder();

        }

    }
}

