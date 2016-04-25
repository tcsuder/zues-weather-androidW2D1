package com.epicodus.zeus;


/**
 * Created by Guest on 4/25/16.
 */
public class Constants {
    public static final String WEATHER_API_KEY = BuildConfig.WEATHER_API_KEY;

    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast/daily?";
    public static final String LOCATION_QUERY_PARAMETER = "q";
    public static final String PREFFERED_FORMAT = "mode";
}


//   &q=London,us
// http://api.openweathermap.org/data/2.5/forecast/location?mode=json&q=portland,us&APPID=30cf89c520e7b10388b2f12bb35ae75b