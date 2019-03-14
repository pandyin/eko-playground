package com.ekoapp.ekoplayground.data.repositories;

import com.ekoapp.ekoplayground.data.datasources.local.EkoLocalDataStore;
import com.ekoapp.ekoplayground.data.datasources.remote.EkoRemoteDataStore;

public abstract class EkoRepository<LOCAL extends EkoLocalDataStore, REMOTE extends EkoRemoteDataStore> {

    private final LOCAL local;
    private final REMOTE remote;

    EkoRepository(LOCAL local, REMOTE remote) {
        this.local = local;
        this.remote = remote;
    }

    LOCAL getLocal() {
        return local;
    }

    REMOTE getRemote() {
        return remote;
    }
}
