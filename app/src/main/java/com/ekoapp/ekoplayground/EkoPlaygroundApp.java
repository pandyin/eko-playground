package com.ekoapp.ekoplayground;

import android.app.Application;

import com.ekoapp.ekoplayground.room.EkoDatabase;

public class EkoPlaygroundApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EkoDatabase.init(this);
    }
}
