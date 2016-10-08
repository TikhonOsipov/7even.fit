package com.tixon.a7evenfit.screens.main_screen;

import android.os.Bundle;

import com.tixon.a7evenfit.R;
import com.tixon.a7evenfit.dagger.components.DaggerIScreensComponent;
import com.tixon.a7evenfit.dagger.components.IAppComponent;
import com.tixon.a7evenfit.dagger.components.IScreensComponent;
import com.tixon.a7evenfit.dagger.modules.ScreensModule;
import com.tixon.a7evenfit.screens.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainView {
    IScreensComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        component = DaggerIScreensComponent.builder()
                .iAppComponent(appComponent)
                .screensModule(new ScreensModule(this))
                .build();
        component.inject(this);
    }
}
