package com.open.gov.data;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.open.gov.data.adapter.AQIAdaptor;
import com.open.gov.data.entity.AQIEntity;
import com.open.gov.data.jsonobject.CommonConstant;
import com.open.gov.data.jsonobject.JsonToObject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class APIResultActivity extends AppCompatActivity {
    Intent intent;
    ListView mainListView;
    AQIAdaptor aqiAdaptor;
    ArrayList<AQIEntity> listAQI;
    LinearLayout processBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_apiresult);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_aqi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        intent = new Intent(getApplicationContext(), AQISearch.class);
        processBar = (LinearLayout)findViewById(R.id.processBar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String state = intent.getStringExtra("state");
        String city = intent.getStringExtra("city");
        String station = intent.getStringExtra("station");
        TextView stationText = (TextView)findViewById(R.id.stationText);
        stationText.setText(station);
        String url = CommonConstant.baseurl+"&format=json&offset=0&filters[country]=India&filters[state]="+state+"&filters[city]="+city+"&filters[station]="+station;
        new JsonTask().execute(url);
    }

    private class JsonTask extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            processBar.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            JsonToObject jsonToObject = new JsonToObject();
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                }
                JSONObject jsonObject = new JSONObject(buffer.toString());
                listAQI = jsonToObject.parseDataSetAQIList(jsonObject);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (JSONException je){
                je.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            processBar.setVisibility(View.GONE);
            mainListView = (ListView)findViewById(R.id.listViewAQI);
            aqiAdaptor = new AQIAdaptor(APIResultActivity.this,R.layout.inc_aqi_layout,listAQI);
            mainListView.setAdapter(aqiAdaptor);
        }
    }


}
