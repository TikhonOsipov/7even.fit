package com.tixon.a7evenfit.screens.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tixon.a7evenfit.app.App;
import com.tixon.a7evenfit.dagger.components.IAppComponent;

/**
 * Created by tikhon.osipov on 08.10.16
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    protected abstract void setupComponent(IAppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.get(this).getAppComponent());
    }

    @Override
    public void startView(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
