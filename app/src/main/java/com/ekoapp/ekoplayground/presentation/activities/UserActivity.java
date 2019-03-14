package com.ekoapp.ekoplayground.presentation.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.ekoapp.ekoplayground.R;
import com.ekoapp.ekoplayground.R2;
import com.ekoapp.ekoplayground.presentation.activities.intents.ChatIntent;
import com.ekoapp.ekoplayground.presentation.contracts.LogInContract;
import com.ekoapp.ekoplayground.presentation.presenters.UserPresenter;
import com.ekoapp.ekoplayground.presentation.viewmodels.UserViewModel;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.ScopeProvider;

import butterknife.BindView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class UserActivity extends EkoActivity implements LogInContract {

    @BindView(R2.id.username_edit_text)
    EditText username;
    @BindView(R2.id.password_edit_text)
    EditText password;
    @BindView(R2.id.log_in_button)
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Flowable.combineLatest(RxTextView.afterTextChangeEvents(username).toFlowable(BackpressureStrategy.BUFFER),
                RxTextView.afterTextChangeEvents(password).toFlowable(BackpressureStrategy.BUFFER),
                (username, password) -> username.getEditable() != null && username.getEditable().length() > 0
                        && password.getEditable() != null && password.getEditable().length() > 0)
                .doOnNext(logIn::setEnabled)
                .as(AutoDispose.autoDisposable(this))
                .subscribe();

        UserViewModel viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        UserPresenter presenter = new UserPresenter(viewModel, this);
        presenter.logIn();
        logIn.setOnClickListener(v -> presenter.logIn(username.getText().toString(), password.getText().toString()));
    }

    @Override
    public void onLoggedIn() {
        startActivity(new ChatIntent(this));
        finish();
    }

    @Override
    public ScopeProvider getScopeProvider() {
        return this;
    }
}
