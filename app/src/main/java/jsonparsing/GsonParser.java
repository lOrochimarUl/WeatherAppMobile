package jsonparsing;

import com.google.gson.Gson;
import current_weather.Root;

import java.io.FileReader;

public class GsonParser {

    public Root parse_current_weather(String current_weather) {

        Gson gson = new Gson();
        Root root = gson.fromJson(current_weather, Root.class);

        return root;

      /*  try(FileReader reader = new FileReader("test_current_weather.json")){

            Root root = gson.fromJson(reader, Root.class);

            return root;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       */
    }

    public Root parse_fd_forecast() { //parsing five days forecast

        Gson gson = new Gson();

        try(FileReader reader = new FileReader("test_five_days_forecast.json")){

            Root root = gson.fromJson(reader, Root.class);

            return root;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
