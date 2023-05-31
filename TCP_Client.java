import java.io.*;
import java.net.*;

public class TCP_Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 12345); // Connect to the server on localhost with the specified port
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            
            String inputLine;
            
            while (true) {
                System.out.print("Client: ");
                String message = consoleReader.readLine(); // Read the client's message from the console
                
                out.println(message); // Send the message to the server
                
                if (message.equals("bye"))
                    break;
                
                inputLine = in.readLine(); // Receive the server's response
                System.out.println("Server: " + inputLine); // Print the server's response
            }
            
            in.close();
            out.close();
            clientSocket.close();
            
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
}
}
}