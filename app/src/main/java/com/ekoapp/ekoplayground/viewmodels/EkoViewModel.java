package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.ekoapp.ekoplayground.activities.EkoActivity;

public abstract class EkoViewModel extends AndroidViewModel {

    EkoViewModel(@NonNull Application application) {
        super(application);
    }

    public static <VM extends EkoViewModel> VM get(EkoActivity activity, Class<VM> cls) {
        return ViewModelProviders.of(activity).get(cls);
    }
}
