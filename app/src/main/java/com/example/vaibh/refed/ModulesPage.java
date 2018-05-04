package com.example.vaibh.refed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

public class ModulesPage extends AppCompatActivity {

    VideoView vv2;


    Module module1 = new Module(" Ratios and Proportional Relationships", R.drawable.calculation,0);
    Module module2 = new Module("The Number System", R.drawable.calculation,0);
    Module module3 = new Module("Expressions and Equations", R.drawable.calculation,0);
    Module module4 = new Module("Geometry", R.drawable.calculation,0);
    Module module5 = new Module("Statistics and Probability ", R.drawable.calculation,0);



    ListView list;
    String[] itemname ={
            module1.name, module2.name,module3.name,module4.name,module5.name,

    };

    Integer[] imgid={
            module1.imgID,module2.imgID,module3.imgID,module4.imgID,module5.imgID,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_page);

        ListAdapter adapter=new ListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        vv2 = findViewById(R.id.videoView2);
        list.setAdapter(adapter);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.part1_intro_video);
        vv2.setVideoPath(uri.toString());
        vv2.requestFocus();
        vv2.start();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname[+position];
                if(position == 0) {
                    Intent i = new Intent(getApplicationContext(), MathModule1_Part1.class);
                    startActivity(i);
                }
            }
        });
    }
}