import java.io.*;
import java.net.*;
import java.util.Scanner;
public class BitStuffingClient {
public static void main(String[] args) throws Exception {
System.out.println("connected");
System.out.println("Enter the sequence of bits:");
Scanner scanner=new Scanner(System.in);
String bitStream = scanner.nextLine();
String stuffedStream = bitStuffing(bitStream);
Socket clientSocket = new Socket("localhost", 1234);
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
outToServer.writeUTF(stuffedStream);
clientSocket.close();
}
private static String bitStuffing(String bitStream) {
String stuffedStream = "";
int count = 0;
for (int i = 0; i < bitStream.length(); i++) {
if (bitStream.charAt(i) == '1') {
count++;
stuffedStream += '1';
} else {
count = 0;
stuffedStream += '0';
}
if (count == 5) {
count = 0;
stuffedStream += '0';
}
}
return stuffedStream;
}
}