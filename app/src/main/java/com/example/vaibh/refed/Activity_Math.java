package com.example.vaibh.refed;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Activity_Math extends AppCompatActivity {

    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__math);

        Context context = Activity_Math.this;

        c = Activity_Math.this;

        String json = loadJSONFromAsset("assets/fonts/Math_Part_1_Section_1");

        /*String json;
        JSONObject obj;
        try {
            InputStream is = getAssets().open("assets/fonts/Math_Part_1_Section_1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            obj = new JSONObject(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }*/



    }

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

//    public String loadJSONFromAsset(Context context) {
//        String json = null;
//        try {
//            InputStream is = context.getAssets().open("Math_Part_1_Section_1.json");
//
//            int size = is.available();
//
//            byte[] buffer = new byte[size];
//
//            is.read(buffer);
//
//            is.close();
//
//            json = new String(buffer, "UTF-8");
//
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//
//    }
}
