package com.example.gridviewwithcustomadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] itemNames;
    private int[] itemIcons;

    public GridAdapter(Context context , String[] itemNames , int[] itemIcons){

        this.context = context;
        this.itemNames = itemNames;
        this.itemIcons = itemIcons;
    }

    @Override
    public int getCount(){
        return itemNames.length;
    }

    @Override
    public Object getItem(int position){
        return itemNames[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView iconView = convertView.findViewById(R.id.icon);
        TextView nameView = convertView.findViewById(R.id.name);

        iconView.setImageResource(itemIcons[position]);
        nameView.setText(itemNames[position]);

        return convertView;
    }
}
