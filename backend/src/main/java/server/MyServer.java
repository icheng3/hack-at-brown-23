package server;

import server.handlers.campHandler;
import static spark.Spark.after;
import spark.Spark;

/**
 * Top-level class for this demo. Contains the main() method which starts Spark and runs the various
 * handlers.
 *
 * <p>We have three endpoints in this demo: loadcsv, getcsv, and weather. Requests to loadcsv loads
 * a CSV file if one is located at the specified path, provided by the query parameter 'filepath.'
 * Requests to getcsv sends back the previously loaded CSV file's contents as a Json 2-dimensional
 * array. loadcsv and getcsv share a state, specifically a HashMap that maps the filepath to the
 * parsed data of its corresponding CSV file's contents. Requests to weather sends back the
 * temperature at the specified location provided by its query parameters 'lat' and 'lon'
 * corresponding to latitude and longitude, respectively.
 */
public class MyServer {
  public static void main(String[] args) {
    Spark.port(3005);

    after(
        (request, response) -> {
          response.header("Access-Control-Allow-Origin", "*");
          response.header("Access-Control-Allow-Methods", "*");
        });

    // Setting up the handler for the loadcsv endpoint
    Spark.get("camp", new campHandler());

    System.out.println("Server started.");

    Spark.init();
    Spark.awaitInitialization();
  }
}
