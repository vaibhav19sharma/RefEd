package com.example.vaibh.refed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentQuestions extends Fragment {

    View fragQuestion;
    RadioButton rb1, rb2, rb3, rb4;
    ImageView imgImage;
    RadioGroup rdg1;
    String moduleName;
    org.json.JSONObject obj;
    int tries =0;
    public FragmentQuestions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragQuestion= inflater.inflate(R.layout.fragment_questions, container, false);
        String json = null;
        if (getArguments() != null) {
            String moduleName = getArguments().getString("params");
            Log.i("TEST","Received: "+ moduleName);
        }
        rb1 = (RadioButton)fragQuestion.findViewById(R.id.ChoiceA);
        rb2 = fragQuestion.findViewById(R.id.ChoiceB);
        rb3 = fragQuestion.findViewById(R.id.ChoiceC);
        rb4 = fragQuestion.findViewById(R.id.ChoiceD);
        try {
            InputStream is = getActivity().getAssets().open("Math_Part_1_Section_1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            obj = new JSONObject(json);
            rb1.setText("hi");
            JSONObject parts = obj.getJSONObject("Parts");
            JSONArray sections = parts.getJSONArray("Sections");
            for(int i=0; i<5;i++){
                JSONObject sec = sections.getJSONObject(i);
                String name = sec.getString("Name");
                Log.i("TESTmod",Activity_Math.moduleName);
                Log.i("TESTname",Activity_Math.moduleName);
                if(moduleName == name){
                    JSONArray choices = sec.getJSONArray("Choices");
                    JSONArray choices2 = choices.getJSONArray(0);
                    rb1.setText(choices2.getString(0));
                    rb2.setText(choices2.getString(1));
                    rb3.setText(choices2.getString(2));
                    rb4.setText(choices2.getString(3));
                    break;
                }
            }
            //JSONObject sec = sections.getJSONObject(0);
            //String name = sec.getString("Name");
            //rb1.setText(name);
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
            json = null;
            obj = null;
        }



        // To pull a value from the JSON file:
        // String section = obj.getJsonString("Section_Name");

        rdg1 = fragQuestion.findViewById(R.id.rdgChoices);
        rdg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Toast.makeText(getContext(),"Item clicked : " + Integer.toString(checkedId),Toast.LENGTH_LONG).show();
            }
        });
        fragQuestion.findViewById(R.id.imgImage);
            TextView txtheading = fragQuestion.findViewById(R.id.txtSubPart);
            TextView txtQuestion = fragQuestion.findViewById(R.id.txtContent);
            imgImage = fragQuestion.findViewById(R.id.imgImage);
            txtheading.setText("Basic Ratios");
            txtQuestion.setText("The table shows the amount of games available at a local school. What is the ratio of board games to chess games?");
            imgImage.setImageResource(R.drawable.mathpart1q1);
            rb1.setText("4/3");
            rb2.setText("3/4");
            rb3.setText("3/2");
            rb4.setText("5/3");
            if(tries !=0) {
                TextView hint = fragQuestion.findViewById(R.id.txtHint);
                hint.setText("Counting the amount of board games and chess games will help you find the ratio between them.");
            }

        return fragQuestion;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ChoiceA:
                if (checked)
                    tries+=1;
                    break;
            case R.id.ChoiceB:
                if (checked)
                    Toast.makeText(getContext(),"Correct Answer!",Toast.LENGTH_LONG).show();
                    break;
            case R.id.ChoiceC:
                if (checked)
                    tries+=1;
                    // action
                    break;
            case R.id.ChoiceD:
                if (checked)
                    tries+=1;
                    // action
                    break;
        }
    }

}
