package com.tixon.a7evenfit.app;

import android.app.Application;
import android.content.Context;

import com.tixon.a7evenfit.dagger.components.DaggerIAppComponent;
import com.tixon.a7evenfit.dagger.components.IAppComponent;
import com.tixon.a7evenfit.dagger.modules.AppModule;

/**
 * Created by tikhon.osipov on 08.10.16
 */
public class App extends Application {
    private IAppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraph();
    }

    private void buildGraph() {
        appComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public IAppComponent getAppComponent() {
        return appComponent;
    }
}
