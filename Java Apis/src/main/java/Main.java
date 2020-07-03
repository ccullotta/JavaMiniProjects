import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++){
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                var result = new JSONObject(response.body());
                String joke = result.get("value").toString();
                list.add(joke);
            }
            for (String joke: list) {
                System.out.println(joke);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FUCK YEAASS");
    }
}
