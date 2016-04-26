package com.epicodus.zeus;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Guest on 4/25/16.
 */
public class Forecast {
    public static final String TAG = Forecast.class.getSimpleName();
    private String mTime;
    private int mTempMin;
    private int mTempMax;
    private Double mHumidity;
    private String mWeatherMain;
    private String mWeatherDescription;
    private String mWeatherIcon;
    private Double mWindSpeed;
    private Double mClouds;

    public static double round(double val, int prin) {
        int scale = (int) Math.pow(10, prin);
        return (double) Math.round(val*scale)/scale;
    }

    public Forecast(long time, Double tempMin, Double tempMax, Double humidity,
                    String
            weatherMain, String weatherDescription, String weatherIcon, Double windSpeed, Double
            clouds) {

        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MM/dd/yyyy");
        Log.d(TAG, "TIMEY TIME" + time);
        String stringTime = sdf.format(new Date(time * 1000));
        Log.d(TAG, "STRINGY TIMEY" + stringTime);
        String iconUrl = "http://openweathermap.org/img/w/" + weatherIcon + ".png";

        Double maxTempF = 1.8*(tempMax-273)+32;
        Integer maxTempFInt = maxTempF.intValue();

        Double minTempF = 1.8*(tempMin-273)+32;
        Integer minTempFInt = minTempF.intValue();

        Double windSpeedRounded = round(windSpeed, 1);

        this.mTime = stringTime;
        this.mTempMin = minTempFInt;
        this.mTempMax = maxTempFInt;
        this.mHumidity = humidity;
        this.mWeatherMain = weatherMain;
        this.mWeatherDescription = weatherDescription;
        this.mWeatherMain = weatherMain;
        this.mWeatherIcon = iconUrl;
        this.mWindSpeed = windSpeedRounded;
        this.mClouds = clouds;
    }

    public String getTime() {
        return mTime;
    }

    public Integer getTempMin() {
        return mTempMin;
    }

    public Integer getTempMax() {
        return mTempMax;
    }

    public Double getHumidity() {
        return mHumidity;
    }

    public String getWeatherMain() {
        return mWeatherMain;
    }

    public String getWeatherDescription() {
        return mWeatherDescription;
    }

    public String getWeatherIcon() { return mWeatherIcon; }

    public Double getWindSpeed() {
        return mWindSpeed;
    }

    public Double getClouds() {
        return mClouds;
    }
}
