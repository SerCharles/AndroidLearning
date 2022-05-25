
package com.example.android.tabexperiment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {


    //To do
    //implement the constructor and override onCreateView
    public TabFragment1()
    {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1,container,false);
        return view;

    }
    //To do closed
}
