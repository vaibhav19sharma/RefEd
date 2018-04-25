package com.example.vaibh.refed;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class JSONObject extends AppCompatActivity{

    public String loadJSONFromAsset(String fileName) {
        String json = null;
        org.json.JSONObject obj;
        try {
            InputStream is = getAssets().open(fileName + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            obj = new org.json.JSONObject(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
