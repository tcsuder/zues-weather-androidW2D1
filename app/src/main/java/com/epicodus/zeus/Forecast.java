package com.epicodus.zeus;

/**
 * Created by Guest on 4/25/16.
 */
public class Forecast {
    private String mTime;
    private Double mTempMin;
    private Double mTempMax;
    private Double mHumidity;
    private String mWeatherMain;
    private String mWeatherDescription;
    private String mWeatherIcon;
    private Double mWindSpeed;
    private Double mClouds;

    public Forecast(int time, double tempMin, double tempMax, double humidity, String
            weatherMain, String weatherDescription, String weatherIcon, double windSpeed, double
            clouds) {

        String stringTime = new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util
                .Date (time * 1000));
        String iconUrl = "http://openweathermap.org/img/w/" + weatherIcon + ".png";

        this.mTime = stringTime;
        this.mTempMin = tempMin;
        this.mTempMax = tempMax;
        this.mHumidity = humidity;
        this.mWeatherMain = weatherMain;
        this.mWeatherDescription = weatherDescription;
        this.mWeatherMain = weatherMain;
        this.mWeatherIcon = iconUrl;
        this.mWindSpeed = windSpeed;
        this.mClouds = clouds;
    }


    public String getTime() {
        return mTime;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public Double getTempMax() {
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

    public String getWeatherIcon() {
        return mWeatherIcon;
    }

    public Double getWindSpeed() {
        return mWindSpeed;
    }

    public Double getClouds() {
        return mClouds;
    }
}
