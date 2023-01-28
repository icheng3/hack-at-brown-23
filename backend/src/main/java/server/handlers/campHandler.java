package server.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;

public class campHandler implements DataHandler {


  @Override
  public Object handle(Request request, Response response) {
    QueryParamsMap queryMap = request.queryMap();
    return this.handleData(queryMap);
  }

  @Override
  public String handleData(QueryParamsMap queryMap) {
    try {
      if ((!(queryMap.hasKey("state"))) && (!(queryMap.hasKey("city")))) {
        Map<String, Object> results = new LinkedHashMap<>();
        results.put("result", "error_bad_request");
        return new ResponseUtilities().serialize(results);
      } else {
        String state = queryMap.get("state").value();
        String city = queryMap.get("city").value();
        Map<String, String> coordinates = this.getCoordinates(state, city);
        String campgroundData = this.getCampgroundData(coordinates);
        Map<String, Object> results = new LinkedHashMap<>();
        results.put("result", "success");
        results.put("campData", campgroundData);
        return new ResponseUtilities().serialize(results);
      }
    } catch (Exception e) {
      Map<String, Object> results = new LinkedHashMap<>();
      results.put("result", "error_datasource");
      return new ResponseUtilities().serialize(results);
    }
  }


  public Map<String, String> getCoordinates(String state, String city)
      throws IOException, InterruptedException, ApiException {
    if (state == null || state.isEmpty()) {
      return new LinkedHashMap<>();
    } else if (city == null || city.isEmpty()) {
      return this.geoCode(state.trim());
    } else {
      return this.geoCode(city.trim() + "," + state.trim());
    }
  }

  public Map<String, String> geoCode(String query)
      throws IOException, InterruptedException, ApiException {
    GeoApiContext context = new GeoApiContext.Builder()
        .apiKey("AIzaSyDb7HG6b7O-sJQpcL8ruMw5oAYWUt8-biA")
        .build();
    GeocodingResult[] results = GeocodingApi.geocode(context,
        query).await();
    String lat = String.valueOf(results[0].geometry.location.lat);
    String lon = String.valueOf(results[0].geometry.location.lng);
// Invoke .shutdown() after your application is done making request
    Map<String, String> coordinates = new LinkedHashMap<>();
    coordinates.put("lat", lat);
    coordinates.put("lon", lon);
    context.shutdown();
    return coordinates;
  }

  public String getCampgroundData(Map<String, String> coordinates)
      throws IOException, URISyntaxException, InterruptedException {
    String lat = coordinates.get("lat");
    String lon = coordinates.get("lon");
//    String campURL = "http://api.amp.active.com/camping/campgrounds?landmarkName=true&landmarkLat="
//        + lat + "&landmarkLong=" + lon + "&xml=true&api_key=d8maebawtht4vba9bxyqs48w";
    String campURL = "http://api.amp.active.com/camping/campgrounds?landmarkName=true&landmarkLat=36.778261&landmarkLong=-119.417932&xml=true&api_key=d8maebawtht4vba9bxyqs48w";
//    String campURL = "https://www.reserveamerica.com/campgroundSearch.do?landmarkName=true&landmarkLat=36.778261&landmarkLong=-119.417932&xml=true&xml=true&expwith=1&expfits=1";
    String campXML = APIUtilities.getURLResponse(campURL);
//    String campXML = campEndPoint.body();
//    return XML.toJSONObject(campXML).toString();
    return campXML;
  }
}
