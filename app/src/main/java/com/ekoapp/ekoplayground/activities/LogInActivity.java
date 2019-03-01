package com.ekoapp.ekoplayground.activities;

import android.os.Bundle;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.activities.intents.ChatListIntent;
import com.ekoapp.ekoplayground.viewmodels.EkoViewModel;
import com.ekoapp.ekoplayground.viewmodels.LogInViewModel;

public class LogInActivity extends EkoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInViewModel viewModel = EkoViewModel.get(this,
                LogInViewModel.class);

        viewModel.getUser()
                .doOnSuccess(user -> {
                    startActivity(new ChatListIntent(this));
                    finish();
                })
                .subscribe();
    }
}
