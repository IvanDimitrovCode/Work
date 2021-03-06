package com.example.ivandimitrov.multithreading.Adapters;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ivandimitrov.multithreading.NodeTypes.CitiesWeather;
import com.example.ivandimitrov.multithreading.R;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<CitiesWeather> {

    private final Activity context;
    private ArrayList<CitiesWeather> citiesList = new ArrayList<CitiesWeather>();

    public CustomListAdapter(Activity context, ArrayList<CitiesWeather> itemname) {
        super(context, R.layout.activity_listview, itemname);
        this.context = context;
        this.citiesList = itemname;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_listview, null, true);
            viewHolder.txtTitle = (TextView) view.findViewById(R.id.label);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtTitle.setText(citiesList.get(position).getName());
        return view;
    }

    static class ViewHolder {
        TextView txtTitle;
    }
}
