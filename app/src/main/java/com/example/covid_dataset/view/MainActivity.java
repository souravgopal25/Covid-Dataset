package com.example.covid_dataset.view;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid_dataset.R;
import com.example.covid_dataset.model.Data;
import com.example.covid_dataset.viewModel.MainActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    Data mData;
    @BindView(R.id.text)
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        //OBSERVER
        mainActivityViewModel.getData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                mData = data;
                List<Data.StatewiseBean> mlist=mData.getStatewise();
                for (Data.StatewiseBean statewise:mlist){
                    if (statewise.getState().equals("Total")){
                        text.setText(statewise.getState() +" "+statewise.getConfirmed());
                    }
                }
            }
        });


    }
}