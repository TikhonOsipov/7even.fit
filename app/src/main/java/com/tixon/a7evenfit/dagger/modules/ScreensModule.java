package com.tixon.a7evenfit.dagger.modules;

import com.tixon.a7evenfit.dagger.scopes.ActivityScope;
import com.tixon.a7evenfit.screens.main_screen.IMainPresenter;
import com.tixon.a7evenfit.screens.main_screen.IMainView;
import com.tixon.a7evenfit.screens.main_screen.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tikhon.osipov on 08.10.16
 */
@Module
public class ScreensModule {
    private IMainView mainView;

    public ScreensModule(IMainView view) {
        this.mainView = view;
    }

    @Provides
    public IMainView provideMainView() {
        return mainView;
    }

    @Provides
    @ActivityScope
    public IMainPresenter provideMainPresenter() {
        return new MainPresenter(mainView);
    }
}
