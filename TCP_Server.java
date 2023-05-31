import java.io.*;
import java.net.*;

public class TCP_Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Create a server socket with a specified port
            
            System.out.println("Server started. Waiting for clients...");
            
            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
            
            System.out.println("Client connected.");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine); // Print the client's message
                
                System.out.print("Server: ");
                String response = consoleReader.readLine(); // Read the server's response from the console
                
                out.println(response); // Send the response to the client
                
                if (response.equals("bye"))
                    break;
            }
            
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
