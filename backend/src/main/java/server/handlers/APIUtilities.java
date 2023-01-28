package server.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import spark.utils.IOUtils;

/**
 * Class that establishes a connection between the server and a URL endpoint.
 */
public class APIUtilities {

  /**
   * Establishes the server's connection with a provided URL endpoint and
   * returns the contents of the endpoint.
   * @param url - the URL to establish a connection with
   * @return - the contents of the enpoint
   * @throws IOException when a connection is unable to be established with the API
   * @throws InterruptedException when the connection to the API is interrupted
   * @throws URISyntaxException when the GET request to the API is ill-formatted
   */
  public static String getURLResponse(String url)
      throws IOException, URISyntaxException, InterruptedException {
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    int responseCode = con.getResponseCode();
    System.out.println("GET Response Code :: " + responseCode);
//      if (responseCode == HttpURLConnection.HTTP_OK) { // success
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    // print result
    return response.toString();

//      } else {
//        return "GET request did not work.";
//      }


//    URL requestURL = new URL(url);
//    HttpURLConnection clientConnection = (HttpURLConnection) requestURL.openConnection();
//    clientConnection.setRequestMethod("GET");
//    clientConnection.connect();
//    HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
//    HttpResponse<String> endPoint =
//        HttpClient.newBuilder().build().send(httpRequest, BodyHandlers.ofString());
//    clientConnection.disconnect();
//    return endPoint;
  }
}
