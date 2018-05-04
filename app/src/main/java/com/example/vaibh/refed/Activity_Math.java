package com.example.vaibh.refed;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Activity_Math extends AppCompatActivity {

    private Context c;
    private RadioButton rb1;
    private Bundle extra;
    private Fragment frag;
    public static String moduleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__math);

        Context context = Activity_Math.this;
        extra = getIntent().getExtras();
        moduleName = extra.getString("Name");
        Log.i("TESTFRAG",moduleName);

        c = Activity_Math.this;

        FragmentQuestions myObj = new FragmentQuestions();
        Bundle bundle = new Bundle();
        bundle.putString("Name",moduleName);
        myObj.setArguments(bundle);
        Log.i("TESTFRAG",moduleName + "sent");
        //String json = loadJSONFromAsset("Math_Part_1_Section_1");





    }

    /*public String loadJSONFromAsset(String fileName) {
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
    }*/


}
