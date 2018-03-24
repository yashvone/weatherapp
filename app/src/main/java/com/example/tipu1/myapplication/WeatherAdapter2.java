package com.example.tipu1.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tipu1 on 3/21/2018.
 */

public class WeatherAdapter2 extends ArrayAdapter<Weather> {
    public WeatherAdapter2(@NonNull Context context, ArrayList<Weather> weatherArrayList) {
        super(context, 0, weatherArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Weather weather = getItem(position);
        Context context;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView dateTextView = convertView.findViewById(R.id.tvDate);
        TextView temperatureTextView = convertView.findViewById(R.id.tvHighTemperature);
        TextView weatherTextView = convertView.findViewById(R.id.tvLowTemperature);
        TextView firstTextView = convertView.findViewById(R.id.first);
        TextView secondTextView = convertView.findViewById(R.id.second);

        dateTextView.setText(weather.getDate());
        temperatureTextView.setText(weather.getMaxTemp());
        weatherTextView.setText(weather.getMinTemp());
        firstTextView.setText(weather.getFirst());
        secondTextView.setText(weather.getSecond());

        return convertView;
    }
}

