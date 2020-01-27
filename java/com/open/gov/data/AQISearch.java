package com.open.gov.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.open.gov.data.jsonobject.CommonConstant;
import com.open.gov.data.jsonobject.JsonToObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AQISearch extends AppCompatActivity {
    Intent intentBack;
    Intent intent;
    Spinner state;
    Spinner city;
    Spinner station;
    JSONObject jsonDataObj;
    String selectedState;
    String selectedCity;
    String selectedStation;
    JsonToObject jsonToObject = new JsonToObject();
    Button aqiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_aqisearch);
        Toolbar toolbar = findViewById(R.id.aqiToolbar);
        toolbar.setTitle(R.string.title_search_aqi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        intentBack = new Intent(getApplicationContext(), MainActivity.class);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentBack);
            }
        });
        intent = new Intent(getApplicationContext(), APIResultActivity.class);
        state = (Spinner) findViewById(R.id.state);
        city = (Spinner) findViewById(R.id.city);
        station = (Spinner) findViewById(R.id.station);
        List<String> stateList = getStateData(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stateList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(dataAdapter);
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedState = state.getSelectedItem().toString().trim();
                populateCity();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = city.getSelectedItem().toString().trim();
                populateStation();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedStation = station.getSelectedItem().toString().trim();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        aqiButton = (Button)findViewById(R.id.aqiButton);
        aqiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("state",selectedState);
                intent.putExtra("city",selectedCity);
                intent.putExtra("station",selectedStation);
                startActivity(intent);
            }
        });
    }

    public void populateCity(){
        List<String> cityList = jsonToObject.parseCityList(jsonDataObj,selectedState);
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityList);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(cityAdapter);
    }

    public void populateStation(){
        List<String> stationList = jsonToObject.parseStationList(jsonDataObj,selectedState,selectedCity);
        ArrayAdapter<String> stationAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stationList);
        stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        station.setAdapter(stationAdapter);
    }

    public ArrayList<String> getStateData(Context context) {
        ArrayList<String> finalList = new ArrayList<String>();
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            jsonDataObj = new JSONObject(json);
            finalList = jsonToObject.parseStateList(jsonDataObj);
        } catch (JSONException jx){
            jx.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return finalList;
    }

}
