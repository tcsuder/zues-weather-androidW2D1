package com.epicodus.zeus;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

//    CREATE MODEL RESTAURANT THEN PROCESS RESULTS METHOD

    public static ArrayList<Forecast> processResults(Response response) {
        ArrayList<Forecast> forecastArray = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            Log.i(TAG, "THIS IS WHAT WERE LOOKING FOR!" + jsonData);
            if (response.isSuccessful()) {
                Log.i(TAG, "success");
                JSONObject weatherJSON = new JSONObject(jsonData);

                JSONArray forecastsJSON = weatherJSON.getJSONArray("list");
                for (int i = 0; i < forecastsJSON.length(); i++) {
                    JSONObject forecastJSON = forecastsJSON.getJSONObject(i);
                    JSONObject tempJSON = forecastJSON.getJSONObject("temp");
                    JSONArray weatherArray = forecastJSON.getJSONArray("weather");
                    JSONObject weatherObject = weatherArray.getJSONObject(0);

                    Integer time = forecastJSON.getInt("dt");
                    double tempMin = tempJSON.getDouble("min");
                    double tempMax = tempJSON.getDouble("max");
                    double humidity = forecastJSON.getDouble("humidity");
                    String weatherMain = weatherObject.getString("main");
                    String weatherDescription = weatherObject.getString("description");
                    String weatherIcon = weatherObject.getString("icon");
                    double windSpeed = forecastJSON.getDouble("speed");
                    double clouds = forecastJSON.getDouble("clouds");

                    Forecast forecast = new Forecast(time, tempMin, tempMax, humidity,
                            weatherMain, weatherDescription, weatherIcon, windSpeed, clouds);

                    forecastArray.add(forecast);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            Log.d(TAG, "fail");
            e.printStackTrace();
        }
        return forecastArray;
    }
}


