package com.ekoapp.ekoplayground.presentation.activities.intents;

import android.content.Context;
import android.content.Intent;

import com.ekoapp.ekoplayground.presentation.activities.EkoActivity;

abstract class EkoIntent<ACTIVITY extends EkoActivity> extends Intent {

    EkoIntent(Context context, Class<ACTIVITY> cls) {
        super(context, cls);
    }
}
