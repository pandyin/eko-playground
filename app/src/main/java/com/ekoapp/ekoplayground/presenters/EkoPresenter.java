package com.ekoapp.ekoplayground.presenters;

import android.arch.lifecycle.AndroidViewModel;

import com.ekoapp.ekoplayground.contract.EkoContract;

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
