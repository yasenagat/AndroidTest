package com.dgcy.http.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation().setPrettyPrinting()
            .create();

    public static <T> T jsonToClass(String responseData, Class<T> classOfT) {
        return gson.fromJson(responseData, classOfT);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }
}
