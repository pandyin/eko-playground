package com.ekoapp.ekoplayground;

import android.app.Application;

import com.ekoapp.ekoplayground.room.EkoDatabase;

public class EkoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EkoDatabase.init(this);
    }
}
