package com.example.brookelin.goodstart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.brookelin.goodstart.R.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class Help extends Fragment {


    public Help() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /* Inflate the layout for this fragment */
        return inflater.inflate(R.layout.fragment_help, container, false);

    }
}