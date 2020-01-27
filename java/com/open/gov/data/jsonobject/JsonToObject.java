package com.open.gov.data.jsonobject;

import com.open.gov.data.entity.AQIEntity;
import com.open.gov.data.entity.DatasetAPIEntity;
import com.open.gov.data.entity.StationEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonToObject {

    public ArrayList<DatasetAPIEntity> parseDataSetAPIList (JSONObject jsonObject){

        ArrayList<DatasetAPIEntity> finalList = new ArrayList<DatasetAPIEntity>();
        DatasetAPIEntity obj = new DatasetAPIEntity();
        try {
            JSONArray jsonArray =  jsonObject.getJSONArray("dataset");
            for(int i=0; i<jsonArray.length();i++){
                JSONObject json = (JSONObject)jsonArray.get(i);
                obj = new DatasetAPIEntity();
                obj.setId(json.getInt("id"));
                obj.setTitle(json.getString("title"));
                obj.setDesc(json.getString("desc"));
                obj.setSector(json.getString("sector"));
                obj.setCreatedDate(json.getString("date"));
                finalList.add(obj);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return finalList;
    }


    public ArrayList<AQIEntity> parseDataSetAQIList (JSONObject jsonObject){
        ArrayList<AQIEntity> finalList = new ArrayList<AQIEntity>();
        AQIEntity obj = new AQIEntity();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("records");
                JSONObject json = (JSONObject)jsonArray.get(0);
                obj = new AQIEntity();
                obj.setState(json.getString("state"));
                obj.setCity(json.getString("city"));
                obj.setStation(json.getString("station"));
                obj.setUpdated(json.getString("last_update"));
                obj.setRow1(json.getString("pollutant_id"));
                obj.setA1_1(json.getString("pollutant_min"));
                obj.setA1_2(json.getString("pollutant_max"));
                obj.setA1_3(json.getString("pollutant_avg"));
                obj.setPm(obj.getRow1());
                if(jsonArray.length() > 1){
                    json = (JSONObject)jsonArray.get(1);
                    obj.setRow2(json.getString("pollutant_id"));
                    obj.setA2_1(json.getString("pollutant_min"));
                    obj.setA2_2(json.getString("pollutant_max"));
                    obj.setA2_3(json.getString("pollutant_avg"));
                    if(obj.getRow2().equalsIgnoreCase("PM10")) {
                        obj.setPm(obj.getRow2());
                    }
                }
                if(jsonArray.length() > 2){
                    json = (JSONObject)jsonArray.get(2);
                    obj.setRow3(json.getString("pollutant_id"));
                    obj.setA3_1(json.getString("pollutant_min"));
                    obj.setA3_2(json.getString("pollutant_max"));
                    obj.setA3_3(json.getString("pollutant_avg"));
                }
                if(jsonArray.length() > 3){
                    json = (JSONObject)jsonArray.get(3);
                    obj.setRow4(json.getString("pollutant_id"));
                    obj.setA4_1(json.getString("pollutant_min"));
                    obj.setA4_2(json.getString("pollutant_max"));
                    obj.setA4_3(json.getString("pollutant_avg"));
                    if(obj.getRow4().equalsIgnoreCase("CO")) {
                        obj.setPm(obj.getRow4());
                    }
                }
                if(jsonArray.length() > 4){
                    json = (JSONObject)jsonArray.get(4);
                    obj.setRow5(json.getString("pollutant_id"));
                    obj.setA5_1(json.getString("pollutant_min"));
                    obj.setA5_2(json.getString("pollutant_max"));
                    obj.setA5_3(json.getString("pollutant_avg"));
                }
                if(jsonArray.length() > 5){
                    json = (JSONObject)jsonArray.get(5);
                    obj.setRow6(json.getString("pollutant_id"));
                    obj.setA6_1(json.getString("pollutant_min"));
                    obj.setA6_2(json.getString("pollutant_max"));
                    obj.setA6_3(json.getString("pollutant_avg"));
                }
            if(jsonArray.length() > 6){
                json = (JSONObject)jsonArray.get(6);
                obj.setRow7(json.getString("pollutant_id"));
                obj.setA7_1(json.getString("pollutant_min"));
                obj.setA7_2(json.getString("pollutant_max"));
                obj.setA7_3(json.getString("pollutant_avg"));
            }
            finalList.add(obj);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return finalList;
    }

    public ArrayList<String> parseStateList (JSONObject jsonObject){

        ArrayList<String> finalList = new ArrayList<String>();
        try {
            JSONArray jsonArray =  jsonObject.getJSONArray("data");
            String str = "";
            String prvStr = "";
            for(int i=0; i<jsonArray.length();i++){
                JSONObject json = (JSONObject)jsonArray.get(i);
                str = json.getString("state");
                if(!str.equalsIgnoreCase(prvStr)) {
                    finalList.add(str);
                    prvStr = str;
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return finalList;
    }

    public ArrayList<String> parseCityList (JSONObject jsonObject, String state){

        ArrayList<String> finalList = new ArrayList<String>();
        try {
            JSONArray jsonArray =  jsonObject.getJSONArray("data");
            String listState = "";
            String str = "";
            String prvStr = "";
            for(int i=0; i<jsonArray.length();i++){
                JSONObject json = (JSONObject)jsonArray.get(i);
                str = json.getString("city");
                listState = json.getString("state");
                if(!str.equalsIgnoreCase(prvStr) && listState.equalsIgnoreCase(state)) {
                    finalList.add(str);
                    prvStr = str;
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return finalList;
    }

    public ArrayList<String> parseStationList (JSONObject jsonObject, String state, String city){

        ArrayList<String> finalList = new ArrayList<String>();
        try {
            JSONArray jsonArray =  jsonObject.getJSONArray("data");
            String listState = "";
            String listCity = "";
            String str = "";
            String prvStr = "";
            for(int i=0; i<jsonArray.length();i++){
                JSONObject json = (JSONObject)jsonArray.get(i);
                listCity = json.getString("city");
                listState = json.getString("state");
                str = json.getString("station");
                if(!str.equalsIgnoreCase(prvStr) && listState.equalsIgnoreCase(state)
                        && listCity.equalsIgnoreCase(city)) {
                    finalList.add(str);
                    prvStr = str;
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return finalList;
    }

}
