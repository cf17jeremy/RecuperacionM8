package com.example.examenfinal;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FetchData extends AsyncTask<Void, Void, Void> {

    protected String data = "";
    protected String results = "";
    protected ArrayList<String> strTypes; // Create an ArrayList object
    protected String city;
    protected String pokId;

    public FetchData(String city) {
        this.city = city;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://alfredobores.com/barcelona.json");
            // Make API connection
            //URL url = new URL(" http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=835babac7f4d7e37f8f51a1abac4fe63");
            Log.i("logtest", "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=835babac7f4d7e37f8f51a1abac4fe63");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // Read API results
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sBuilder = new StringBuilder();

            // Build JSON String
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }

            inputStream.close();
            data = sBuilder.toString();
            Log.d("datarecibida", data);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        JSONObject jObject = null;
        String Main = "";
        String WeatherDescription = "";
        String Temperatura = "";
        String TemperaturaMax = "";
        String TemperaturaMin = "";
        String Humitat = "";
        String VelVent = "";

        try {
            jObject = new JSONObject(data);

            // Get JSON nombre, ingredientes, weight
            results += "Estado: " + jObject.getString("weather") + "\n" +
                    "Descricion: " + jObject.getString("description") + "\n" +
                    "Temperatura: " + jObject.getString("temp") + "\n" +
                    "Temperatura Minima: " + jObject.getString("temp_min") + "\n" +
                    "Temperatura Maxima: " + jObject.getString("temp_min") + "\n" +
                    "Humitat: " + jObject.getString("temp_min") + "\n" +
                    "Vent(velocitat): " + jObject.getString("temp_min");
            Log.d("items", results);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}