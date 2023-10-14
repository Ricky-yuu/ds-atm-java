import java.net.*;
import java.io.*;

public class TCPClient {
   public static void main(String args[]) {
      try {
         Socket socket = new Socket("localhost", 8888);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String userInput;
         while ((userInput = in.readLine()) != null) {
            out.println(userInput);
         }
         out.close();
         in.close();
         socket.close();
      } catch (UnknownHostException e) {
         System.err.println("Unknown host: localhost");
      } catch (IOException e) {
         System.err.println("Couldn't get I/O for the connection to: localhost");
      }
   }
}
