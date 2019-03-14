package com.ekoapp.ekoplayground.presentation.presenters;

import android.arch.lifecycle.AndroidViewModel;

import com.ekoapp.ekoplayground.presentation.contracts.EkoListContract;

public abstract class EkoListPresenter<VM extends AndroidViewModel, CONTRACT extends EkoListContract> extends EkoPresenter<VM, CONTRACT> {

    EkoListPresenter(VM viewModel, CONTRACT contract) {
        super(viewModel, contract);
        init();
    }

    private void init() {
        getContract().setupList();
    }
}
