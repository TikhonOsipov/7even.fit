package com.tixon.a7evenfit.dagger.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tikhon.osipov on 08.10.16
 */
@Module
public class AppModule {
    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApp() {
        return app;
    }
}
