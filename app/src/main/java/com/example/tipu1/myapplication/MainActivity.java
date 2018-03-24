package com.example.tipu1.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Weather> weatherArrayList = new ArrayList<>();
    private ListView listView;

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        URL weatherUrl = NetworkUtils2.buildUrlForWeather();
        new FetchWeatherDetails().execute(weatherUrl);
        Log.i(TAG, "onCreate: weatherUrl: " + weatherUrl);

    }

    private class FetchWeatherDetails extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL weatherUrl = urls[0];
            String weatherSearchResults = null;

            try {
                weatherSearchResults = NetworkUtils2.getResponseFromHttpUrl(weatherUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "doInBackground: weatherSearchResults: " + weatherSearchResults);
            return weatherSearchResults;
        }


        @Override
        protected void onPostExecute(String weatherSearchResults) {
            if (weatherSearchResults != null && !weatherSearchResults.equals("")) {
                weatherArrayList = parseJSON(weatherSearchResults);

                Iterator itr = weatherArrayList.iterator();
                while (itr.hasNext()) {
                    Weather weatherInIterator = (Weather) itr.next();
                    Log.i(TAG, "onPostExecute: Date: " + weatherInIterator.getDate() +
                            "Min" + weatherInIterator.getMinTemp() +
                            "Max" + weatherInIterator.getMaxTemp());
                }
            }
            super.onPostExecute(weatherSearchResults);
        }
    }
    private ArrayList<Weather> parseJSON(String weatherSearchResults) {
        if (weatherArrayList != null) {
            weatherArrayList.clear();
        }
        if (weatherSearchResults != null) {
            try {
                JSONArray results = new JSONArray(weatherSearchResults);
                for (int i = 0; i < results.length(); i++) {
                    Weather weather = new Weather();
                    JSONObject resultsObj = results.getJSONObject(i);

                    String date = resultsObj.getString("LocalObservationDateTime");
                    weather.setDate(date);
                    Log.i(TAG, "parseJSON: date: " + date);

                    JSONObject temperatureObj = resultsObj.getJSONObject("Temperature");
                    String maxTemp = temperatureObj.getJSONObject("Metric").getString("Value");
                    weather.setMaxTemp(maxTemp);
                    Log.i(TAG, "parseJSON: temperature: " + maxTemp);

                    String minTemp = resultsObj.getString("WeatherText");

                    weather.setMinTemp(minTemp);

                    Log.i(TAG, "parseJSON: condition: " + minTemp);

                        /*Log.i(TAG, "parseJSON: date: " + date + " "
                                    + "Min" + minTemperature + " "
                                    + "Max" + maxTemperature);*/
                    weather.setFirst("Temperature");
                    weather.setSecond("Conditions");

                    weatherArrayList.add(weather);
                }
                if (weatherArrayList != null) {
                    WeatherAdapter2 weatherAdapter = new WeatherAdapter2(this, weatherArrayList);
                    listView.setAdapter(weatherAdapter);
                }

                return weatherArrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
