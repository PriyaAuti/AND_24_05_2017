package com.example.fragmentsdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    public static final String KEY_MY_DATA = "myData";

    public static MyFragment getInstance(String myData){
        MyFragment fragment=new MyFragment();

        Bundle args=new Bundle();
        args.putString(KEY_MY_DATA,myData);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_my, container, false);


        rootView.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }

    private void setText(View rootView)
    {
        Bundle bundle=getArguments();
        if(bundle!=null){
            ((TextView) rootView.findViewById(R.id.textData)).setText(bundle.getString(KEY_MY_DATA));

        }
    }

}
