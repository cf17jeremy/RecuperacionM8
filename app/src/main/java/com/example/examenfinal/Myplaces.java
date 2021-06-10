package com.example.examenfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Myplaces extends Fragment {

    public Myplaces() {
        // Required empty public constructor
    }

    public static Myplaces newInstance() {
        Myplaces fragment = new Myplaces();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myplaces, container, false);
    }
}