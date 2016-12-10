package com.tixon.a7evenfit.screens.new_diary_record_screen;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tixon.a7evenfit.dagger.components.DaggerIScreensComponent;
import com.tixon.a7evenfit.dagger.components.IAppComponent;
import com.tixon.a7evenfit.dagger.components.IScreensComponent;
import com.tixon.a7evenfit.dagger.modules.ScreensModule;
import com.tixon.a7evenfit.screens.base.BaseActivity;

/**
 * Created by tikhon.osipov on 04.12.16
 */

public class NewDiaryRecordActivity extends BaseActivity implements INewDiaryRecordView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    ///////////////////////////////////////////////////////////////////////////
    // BaseActivity abstract implemented methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected void setupComponent(IAppComponent appComponent) {
        IScreensComponent component = DaggerIScreensComponent.builder()
                .iAppComponent(appComponent)
                .screensModule(new ScreensModule(this))
                .build();
        component.inject(this);
    }
}
