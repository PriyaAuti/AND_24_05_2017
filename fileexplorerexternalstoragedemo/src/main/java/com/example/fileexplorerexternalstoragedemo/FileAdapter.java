package com.example.fileexplorerexternalstoragedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Home on 6/14/2017.
 */

public class FileAdapter extends BaseAdapter {

    private final Context context;
    private final List<FileItem> files;
    private LayoutInflater inflater;

    public FileAdapter(Context context, List<FileItem> files) {
        this.context = context;
        this.files = files;

        inflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {

        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;

        if(convertView == null) {
            view = inflater.inflate(R.layout.file_item,parent,false);
        }
        else  view=convertView;


        ((ImageView)view.findViewById(R.id.imgIc)).setImageResource(files.get(position).ic);
        ((TextView)view.findViewById(R.id.txtNm)).setText(files.get(position).nm);
        ((TextView)view.findViewById(R.id.txtModi)).setText(files.get(position).modi);
        ((TextView)view.findViewById(R.id.txtSize)).setText(files.get(position).size);

        return view;
    }
}
