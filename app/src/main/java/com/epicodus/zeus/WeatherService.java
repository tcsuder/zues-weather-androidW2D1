package com.epicodus.zeus;
import android.util.Log;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 4/25/16.
 */
public class WeatherService {
    public static final String TAG = WeatherService.class.getSimpleName();

    public static void getWeather(String location, Callback callback) {
        String API_KEY = Constants.WEATHER_API_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location + ",us");
        urlBuilder.addQueryParameter(Constants.PREFFERED_FORMAT, "json");
        urlBuilder.addQueryParameter("appid", API_KEY);
        String url = urlBuilder.build().toString();

        Log.d(TAG, "THIS IS YOUR URL:" + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

//    CREATE MODEL RESTAURANT THEN PROCESS RESULTS METHOD
}
