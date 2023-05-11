import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ChatClientSocket {
 public static void main(String[] args) throws IOException {
 Socket socket = new Socket("localhost", 8080);
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter a message to send to the server: ");
while(true){ 
String message = scanner.nextLine();
 out.println(message);
if(message.contains("Bye")){
break;
}}
 System.out.println("Message sent to server");
 out.close();
 scanner.close();
 socket.close();
 }
}
