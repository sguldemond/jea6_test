package util;

import com.google.gson.Gson;

/**
 * Created by stasiuz on 16/02/2018.
 */
public class JsonConverter {

    public static String convertToJson(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
