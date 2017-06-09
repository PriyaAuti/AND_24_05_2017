package com.example.indiancricketers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Home on 6/8/2017.
 */

public class CustomAdapter extends BaseAdapter {

    private final Context context;
    private final List<CustomItem> items;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<CustomItem> items) {
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;


        if (convertView == null) {
            view = inflater.inflate(R.layout.activity_custom_item, parent, false);
        } else view = convertView;
        ((ImageView) view.findViewById(R.id.imgPrf)).setImageResource(items.get(position).img);
        ((TextView) view.findViewById(R.id.txtName)).setText(items.get(position).nm);
        ((TextView) view.findViewById(R.id.txtAge)).setText(items.get(position).ag);


        return view;
    }
}
