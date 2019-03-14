package com.ekoapp.ekoplayground.presentation.activities;

import android.support.v7.app.AppCompatActivity;

import com.uber.autodispose.ScopeProvider;

import butterknife.ButterKnife;
import io.reactivex.CompletableSource;
import io.reactivex.subjects.CompletableSubject;

public class EkoActivity extends AppCompatActivity implements ScopeProvider {

    private final CompletableSubject completable = CompletableSubject.create();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        completable.onComplete();
    }

    @Override
    public CompletableSource requestScope() throws Exception {
        return completable;
    }
}
