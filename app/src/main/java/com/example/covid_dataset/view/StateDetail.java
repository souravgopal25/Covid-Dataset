package com.example.covid_dataset.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid_dataset.R;
import com.example.covid_dataset.model.Data;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StateDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StateDetail extends Fragment {

    Data.StatewiseBean object;

    public void setObject(Data.StatewiseBean object) {
        this.object = object;
    }

    public StateDetail() {
        // Required empty public constructor
    }


    public static StateDetail newInstance(String param1, String param2) {
        StateDetail fragment = new StateDetail();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_state_detail, container, false);
    }
}