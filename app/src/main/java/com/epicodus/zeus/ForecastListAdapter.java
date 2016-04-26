package com.epicodus.zeus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/26/16.
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{
    private ArrayList<Forecast> mForecastArray = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<Forecast> forecasts) {
        mContext = context;
        mForecastArray = forecasts;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .forecast_day_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecastArray.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecastArray.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherIconImageView) ImageView mWeatherIconImageView;
        @Bind(R.id.forecastDayTextView) TextView mForecastDayTextView;
        @Bind(R.id.weatherMainTextView) TextView mWeatherMainTextView;
        @Bind(R.id.weatherDescriptionTextView) TextView mWeatherDescriptionTextView;
        @Bind(R.id.tempMaxNumberTextView) TextView mTempMaxNumberTextView;
        @Bind(R.id.tempMinNumberTextView) TextView mTempMinNumberTextView;
        @Bind(R.id.windSpeedTextView) TextView mWindSpeedTextView;
        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindForecast(Forecast forecast) {
            Picasso.with(mContext).load(forecast.getWeatherIcon()).into(mWeatherIconImageView);
            mForecastDayTextView.setText(forecast.getTime());
            mWeatherMainTextView.setText(forecast.getWeatherMain());
            mWeatherDescriptionTextView.setText(forecast.getWeatherDescription());
            mTempMaxNumberTextView.setText(forecast.getTempMax().toString());
            mTempMinNumberTextView.setText(forecast.getTempMin().toString());
            mWindSpeedTextView.setText(forecast.getWindSpeed().toString());
        }
    }
}
