package com.example.vaibh.refed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ModulesPage extends AppCompatActivity {


    Module module1 = new Module(" Ratios and Proportional Relationships", R.drawable.ic_menu_send,0);
    Module module2 = new Module("The Number System", R.drawable.ic_search,0);
    Module module3 = new Module("Expressions and Equations", R.drawable.ic_search,0);
    Module module4 = new Module("Geometry", R.drawable.ic_search,0);
    Module module5 = new Module("Statistics and Probability ", R.drawable.ic_search,0);

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
        list.setAdapter(adapter);

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