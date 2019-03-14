package com.ekoapp.ekoplayground;

import android.support.multidex.MultiDexApplication;

import com.ekoapp.ekoplayground.data.persistences.EkoDatabase;

public class EkoApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        EkoDatabase.init(this);
    }
}
