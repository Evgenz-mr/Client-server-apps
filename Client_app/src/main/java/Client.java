import java.util.Scanner;
import java.net.*;
import java.util.*;
import java.io.*;


// pars config file .ini
class ReadIni {
    static int port_srv;
    static String ip_srv;

    int ports() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            int rw = Integer.parseInt(p.getProperty("port"));
            return rw;
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return Integer.parseInt(null);
    }

    String ip_s() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            String rd = p.getProperty("ip");
            return String.valueOf(rd);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    String uname_s() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            String rd = p.getProperty("username");
            return String.valueOf(rd);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    String passwd() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("D:\\tasks\\example.ini"));
            String rd = p.getProperty("password");
            return String.valueOf(rd);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

}

    // A Java program for a Client
 class Client extends ReadIni {

        // constructor to put ip address and port
        private Client(String address, int port) {
            // establish a connection
            // initialize socket and input output streams
            Socket socket = null;
            DataInputStream input = null;
            DataOutputStream out = null;
            try {
                socket = new Socket(address, port);
                try {
                    // add authentication
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter your name: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String passwd = scanner.nextLine();
                    if (uname.equals(uname_s()) && passwd.equals(passwd())) {
                       System.out.println("Correct authentication");
                       System.out.println("user: "+ uname_s() + " - Connected");
                        // takes input from terminal
                        input = new DataInputStream(System.in);
                        // sends output to the socket
                        out = new DataOutputStream(socket.getOutputStream());

                    }
                    else{
                        System.out.println("Incorrect login/password");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } catch (UnknownHostException u) {
                System.out.println(u);
            } catch (IOException i) {
                System.out.println(i);
            }

            // string to read message from input
            String line = "";

            // keep reading until "quit" is input
            while (!line.equals("quit")) {
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            // close the connection
            System.out.println("Closing connection");
            try {
                input.close();
                out.close();
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        public static void main(String args[]) {
            ReadIni ini = new ReadIni();
            ip_srv = ini.ip_s();
            port_srv = ini.ports();
            Client client = new Client(ip_srv, port_srv);
        }
}
