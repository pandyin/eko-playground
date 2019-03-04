package com.ekoapp.ekoplayground.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.activities.intents.ChatListIntent;
import com.ekoapp.ekoplayground.room.entities.User;
import com.ekoapp.ekoplayground.viewmodels.LogInViewModel;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.uber.autodispose.AutoDispose;

import butterknife.BindView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LogInActivity extends EkoActivity {

    @BindView(R2.id.username_edit_text)
    EditText username;
    @BindView(R2.id.password_edit_text)
    EditText password;
    @BindView(R2.id.log_in_button)
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Flowable.combineLatest(RxTextView.afterTextChangeEvents(username).toFlowable(BackpressureStrategy.BUFFER),
                RxTextView.afterTextChangeEvents(password).toFlowable(BackpressureStrategy.BUFFER),
                (username, password) -> username.getEditable() != null && username.getEditable().length() > 0
                        && password.getEditable() != null && password.getEditable().length() > 0)
                .doOnNext(logIn::setEnabled)
                .as(AutoDispose.autoDisposable(this))
                .subscribe();

        LogInViewModel viewModel = ViewModelProviders.of(this)
                .get(LogInViewModel.class);

        Consumer<User> logInConsumer = user -> {
            startActivity(new ChatListIntent(this));
            finish();
        };

        viewModel.logIn()
                .doOnSuccess(logInConsumer)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(this))
                .subscribe();

        logIn.setOnClickListener(v -> viewModel.logIn(username.getText().toString(), password.getText().toString())
                .doOnSuccess(logInConsumer)
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.autoDisposable(this))
                .subscribe());
    }
}
