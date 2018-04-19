package com.example.vaibh.refed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ModulesPage extends AppCompatActivity {


    Module module1 = new Module("Math", R.drawable.ic_menu_send,30);


    ListView list;
    String[] itemname ={
            module1.name,

    };

    Integer[] imgid={
            module1.imgID,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_page);

        ListAdapter adapter=new ListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname[+position];
                Intent i = new Intent(getApplicationContext(),Activity_Math.class);
                startActivity(i);

            }
        });
    }
}