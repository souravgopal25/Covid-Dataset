package com.example.covid_dataset.view;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_dataset.R;
import com.example.covid_dataset.adapter.StateAdapter;
import com.example.covid_dataset.model.Data;
import com.example.covid_dataset.viewModel.MainActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements StateAdapter.ListItemClickListener {
    MainActivityViewModel mainActivityViewModel;
    Data mData;

    @BindView(R.id.recyler)
    RecyclerView recyler;
    List<Data.StatewiseBean> mlist;
    @BindView(R.id.stateDetail)
    FrameLayout stateDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyler.setLayoutManager(linearLayoutManager);
        recyler.setHasFixedSize(true);
        StateAdapter stateAdapter = new StateAdapter(this, this);
        recyler.setAdapter(stateAdapter);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        //OBSERVER
        mainActivityViewModel.getData().observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                mData = data;
                mlist = mData.getStatewise();
                stateAdapter.setMlist(mlist);
            }
        });


    }

    @Override
    public void onItemClick(int clickedindex) {

        stateDetail.setVisibility(View.VISIBLE);
        Data.StatewiseBean obj = mlist.get(clickedindex);
        FragmentManager fragmentManager = getSupportFragmentManager();
        StateDetail stateDetail = new StateDetail();
        stateDetail.setObject(obj);
        fragmentManager.beginTransaction().add(R.id.stateDetail, stateDetail).commit();


    }
}