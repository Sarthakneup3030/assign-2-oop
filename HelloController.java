import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloController {

    public Movie fetchMovieDetails(String movieName) {
        try {
            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=" + 6235f28402304ddd1091428fe72b85b9+ "&query=" + movieName.replace(" ", "+"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            JsonReader jsonReader = Json.createReader(conn.getInputStream());
            JsonObject jsonObject = jsonReader.readObject();

            if (jsonObject.getJsonArray("results").size() > 0) {
                JsonObject movieData = jsonObject.getJsonArray("results").getJsonObject(0);
                return new Movie(
                        movieData.getString("title"),
                        movieData.getString("release_date"),
                        movieData.getString("overview")
                );
            } else {
                return null; // Movie not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Error occurred
        }
    }
}
