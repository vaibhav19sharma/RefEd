package com.example.vaibh.refed;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__math);

        Context context = Activity_Math.this;

        c = Activity_Math.this;

        //String json = loadJSONFromAsset("assets/fonts/Math_Part_1_Section_1");

        String json;
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
        }

        // To pull a value from the JSON file:
        // String section = obj.getJsonString("Section_Name");

        RadioButton.



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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ChoiceA:
                if (checked)
                    // action
                    break;
            case R.id.ChoiceB:
                if (checked)
                    // action
                    break;
            case R.id.ChoiceC:
                if (checked)
                    // action
                    break;
            case R.id.ChoiceD:
                if (checked)
                    // action
                    break;
        }
    }
}
