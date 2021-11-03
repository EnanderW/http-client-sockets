package me.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8080);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        writer.println("POST /test HTTP/1.1");
        writer.println("Host: 127.0.0.1");
        writer.println("Connection: close");
        writer.println("Accept: */*");
        writer.println("Content-Type: application/json");
        writer.println("Content-Length: 31");
        writer.println();
        writer.println("{ \"name\": \"Ironman\", \"age\": 5 }");

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }



    }
}
