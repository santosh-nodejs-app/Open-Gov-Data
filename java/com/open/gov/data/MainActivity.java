package com.open.gov.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import com.open.gov.data.R.layout;
import com.open.gov.data.adapter.DataSetAdaptor;
import com.open.gov.data.entity.DatasetAPIEntity;
import com.open.gov.data.jsonobject.JsonToObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mainListView;
    DataSetAdaptor dataSetAdaptor;
    ArrayList<DatasetAPIEntity> listDataset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_full_name);
        setSupportActionBar(toolbar);
        mainListView = (ListView)findViewById(R.id.listViewMain);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(layout.inc_banner,mainListView,false);
        Intent intent = new Intent(getApplicationContext(), AQISearch.class);
        listDataset = getAssetJsonData(this);
        dataSetAdaptor = new DataSetAdaptor(MainActivity.this,R.layout.inc_api_dataset,listDataset,intent);
        mainListView.addHeaderView(header);
        mainListView.setAdapter(dataSetAdaptor);

    }

    public static ArrayList<DatasetAPIEntity> getAssetJsonData(Context context) {
        ArrayList<DatasetAPIEntity> finalList = new ArrayList<DatasetAPIEntity>();
        JsonToObject jsonToObject = new JsonToObject();
        try {
            InputStream is = context.getAssets().open("datasetapi.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            JSONObject jsonObj = new JSONObject(json);
            finalList = jsonToObject.parseDataSetAPIList(jsonObj);
        } catch (JSONException jx){
            jx.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return finalList;
    }
}
