package com.ekoapp.ekoplayground.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

abstract class EkoViewModel extends AndroidViewModel {

    EkoViewModel(@NonNull Application application) {
        super(application);
    }
}
