package com.ekoapp.ekoplayground.activities.intents;

import android.content.Context;
import android.content.Intent;

import com.ekoapp.ekoplayground.activities.EkoActivity;

public abstract class EkoIntent<ACTIVITY extends EkoActivity> extends Intent {

    EkoIntent(Context context, Class<ACTIVITY> cls) {
        super(context, cls);
    }
}
