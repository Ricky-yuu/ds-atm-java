import java.net.*;
import java.io.*;

public class URLReader {
  public static void main(String[] args) throws Exception {
    URL url = new URL("https://www.google.com/");
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    in.lines().forEach(System.out::println);
    in.close();
  }
}