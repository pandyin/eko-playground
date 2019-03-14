package com.ekoapp.ekoplayground.presentation.presenters;

import android.arch.lifecycle.AndroidViewModel;

import com.ekoapp.ekoplayground.presentation.contracts.EkoContract;

public abstract class EkoPresenter<VM extends AndroidViewModel, CONTRACT extends EkoContract> {

    private final VM viewModel;
    private final CONTRACT contract;

    EkoPresenter(VM viewModel, CONTRACT contract) {
        this.viewModel = viewModel;
        this.contract = contract;
    }

    VM getViewModel() {
        return viewModel;
    }

    CONTRACT getContract() {
        return contract;
    }
}
