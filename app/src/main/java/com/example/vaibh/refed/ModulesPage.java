package com.example.vaibh.refed;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ModulesPage extends Activity{

    Module module1 = new Module("Human Rights",R.drawable.ic_menu_camera,40);
    Module module2 = new Module("Math", R.drawable.ic_menu_send,30);
    Module module3 = new Module("History", R.drawable.ic_menu_share,60);

    ListView list;
    String[] itemname ={
            module1.name,
            module2.name,
            module3.name
    };

    Integer[] imgid={
            module1.imgID,
            module2.imgID,
            module3.imgID
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter=new ListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
