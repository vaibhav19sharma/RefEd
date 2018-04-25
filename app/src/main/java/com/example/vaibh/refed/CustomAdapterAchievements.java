package com.example.vaibh.refed;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by vaibh on 3/16/2018.
 */

class CustomAdapterAchievements extends ArrayAdapter<String>{
    public CustomAdapterAchievements(@NonNull Context context,String [] completedModules) {
        super(context,R.layout.customachievements, completedModules);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater achievementInflator = LayoutInflater.from(getContext());
        View customView = achievementInflator.inflate(R.layout.customachievements, parent, false);

        String modName = getItem(position);

        TextView moduleName = (TextView) customView.findViewById(R.id.txtModuleName);
        TextView score = (TextView) customView.findViewById(R.id.txtScore);
        ImageView imgBadge = (ImageView) customView.findViewById(R.id.imgBadge);

        moduleName.setText(modName);
        imgBadge.setImageResource(R.drawable.check_false);

        return customView;
    }
}

