package com.example.covid_dataset.viewModel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.covid_dataset.model.Data;
import com.example.covid_dataset.repo.DataRepo;

public class MainActivityViewModel extends AndroidViewModel {

    private String TAG= MainActivityViewModel.class.getSimpleName();
    private Context context;
    private DataRepo dataRepo;
    private LiveData<Data> mData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
        dataRepo=new DataRepo();
        mData=dataRepo.getData(context);

    }
    public LiveData<Data> getData(){
        this.mData=dataRepo.getData(context);
        return mData;
    }




}
