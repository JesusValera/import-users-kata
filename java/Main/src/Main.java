import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

  private static final String USER_URL = "https://randomuser.me/api/?inc=gender,name,email,location&results=5&seed=a9b25cd955e2037h";

  public static void main(String[] args) throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("users.csv");
    Scanner csvFile = new Scanner(is);
    URL url = new URL(USER_URL);
    URLConnection connection = url.openConnection();
    is = connection.getInputStream();
    Scanner webProvider = new Scanner(is);

    while (webProvider.hasNextLine()) {
      System.out.println(webProvider.nextLine());
    }
  }
}
